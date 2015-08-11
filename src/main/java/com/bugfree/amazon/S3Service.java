package com.bugfree.amazon;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.bugfree.config.ConfigService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

import static com.amazonaws.services.s3.model.CannedAccessControlList.PublicRead;
import static com.bugfree.config.Keys.S3_ENABLED;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by pawel on 22.04.15.
 */
@Service
public class S3Service {

    private static final Logger logger = getLogger(S3Service.class);

    @Autowired
    private AmazonS3Client s3;

    @Autowired
    private ConfigService config;

    public void upload(InputStream s, String name, String bucket) throws AmazonClientException {
        if (config.asBoolean(S3_ENABLED))
            s3.putObject(new PutObjectRequest(bucket, name, s, new ObjectMetadata()).withCannedAcl(PublicRead));
        else
            logger.info("Amazon S3 is disabled on this environment. File with name [{}] will not be uploaded", name);
    }

    public String getUrl(String bucket, String name) {
        return s3.getResourceUrl(bucket, name);
    }

    public void delete(String bucket, String name) throws AmazonClientException {
        s3.deleteObject(bucket, name);
    }
}
