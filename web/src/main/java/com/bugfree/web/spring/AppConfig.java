package com.bugfree.web.spring;

import com.amazonaws.services.s3.AmazonS3Client;
import com.bugfree.commons.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by pawel on 11.08.15.
 */
@Configuration
@ComponentScan
@Import(Config.class)
public class AppConfig {

    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public AmazonS3Client amazonS3Client() {
        return new AmazonS3Client();
    }
}
