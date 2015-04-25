package com.bugfree;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pawel on 26.04.15.
 */
@Configuration
public class AppConfig {

    @Bean
    public AmazonS3Client amazonS3Client(){
        return new AmazonS3Client();
    }
}
