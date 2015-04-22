package com.bugfree.amazon;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.bugfree.config.ConfigService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

import static com.bugfree.config.Keys.S3_ENABLED;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by pawel on 22.04.15.
 */
@Service
public class S3Service {

    private final Logger logger = getLogger(S3Service.class);

    private AmazonS3Client s3;

    @Autowired
    private ConfigService config;

    @PostConstruct
    private void init() {
        s3 = new AmazonS3Client();
    }

    public void upload(InputStream s, String name, String bucket) {
        if (config.propertyAsBoolean(S3_ENABLED))
            s3.putObject(bucket, name, s, new ObjectMetadata());
        else
            logger.info("Amazon S3 is disabled on this environment. File [{}] will not be uploaded", name);
    }
}
