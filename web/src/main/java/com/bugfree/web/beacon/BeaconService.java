package com.bugfree.web.beacon;

import com.amazonaws.AmazonClientException;
import com.bugfree.commons.config.ConfigService;
import com.bugfree.web.amazon.S3Service;
import com.bugfree.web.beacon.domain.Beacon;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.bugfree.commons.config.Keys.PHOTOS_BUCKET;
import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by pawel on 25.04.15.
 */
@Service
public class BeaconService {

    private final Logger logger = getLogger(getClass());

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

    public Beacon save(Beacon b) {
        return dao.save(b);
    }

    public Beacon addPhoto(Beacon b, MultipartFile file) {
        b.getData().setImageUrl(s3Service.upload(file, b.getId(), config.property(PHOTOS_BUCKET)));
        return dao.save(b);
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