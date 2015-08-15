package com.bugfree.beacon;

import com.amazonaws.AmazonClientException;
import com.bugfree.amazon.S3Service;
import com.bugfree.beacon.domain.Beacon;
import com.bugfree.config.ConfigService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import static com.bugfree.config.Keys.PHOTOS_BUCKET;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by pawel on 25.04.15.
 */
@Service
public class BeaconService {

    private static final Logger logger = getLogger(S3Service.class);

    @Autowired
    private S3Service s3Service;

    @Autowired
    private BeaconDao dao;

    @Autowired
    private ConfigService config;

    public List<Beacon> find(String uuid, Integer minor, Integer major) {
        return dao.find(uuid, minor, major);
    }

    public Optional<Beacon> findOne(String id) {
        return dao.findOne(id);
    }

    public void save(Beacon b) {
        dao.save(b);
    }

    public boolean addPhoto(Beacon b, MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            s3Service.upload(is, b.getId(), config.property(PHOTOS_BUCKET));
            b.getData().setImageUrl(s3Service.getUrl(config.property(PHOTOS_BUCKET), b.getId()) + "?time=" + currentTimeMillis());
            dao.save(b);
        } catch (IOException | AmazonClientException e) {
            logger.error(format("Can not add photo for beacon [%s] ", b.getId()), e);
            return false;
        }
        return true;
    }

    public void delete(String id) {
        try {
            dao.delete(id);
            s3Service.delete(config.property(PHOTOS_BUCKET), id);
        } catch (AmazonClientException e) {
            logger.error(format("Can not delete photo for beacon [%s] ", id), e);
        }
    }
}