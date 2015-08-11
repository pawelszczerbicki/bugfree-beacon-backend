package com.bugfree.spring;

import com.amazonaws.services.s3.AmazonS3Client;
import com.bugfree.config.ConfigService;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.net.UnknownHostException;

import static com.bugfree.config.Keys.*;

/**
 * Created by pawel on 11.08.15.
 */
@Configuration
@ComponentScan(basePackages = "com.bugfree")
@PropertySource(name="appProperties", value="/WEB-INF/properties/system.properties")
public class AppConfig {

    @Autowired
    private ConfigService config;

    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        UserCredentials auth = new UserCredentials(config.property(MONGO_USERNAME), config.property(MONGO_PASSWORD));
        MongoClient c = new MongoClient(config.property(MONGO_HOST), config.asInteger(MONGO_PORT));
        //TODO change SimpleMongoDbFactory constructor. Current is deprecated
        return new MongoTemplate(new SimpleMongoDbFactory(c, config.property(MONGO_DATABASE), auth));
    }

    @Bean
    public AmazonS3Client amazonS3Client(){
        return new AmazonS3Client();
    }
}
