package com.bugfree.spring;

import com.amazonaws.services.s3.AmazonS3Client;
import com.bugfree.config.ConfigService;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.net.UnknownHostException;

import static com.bugfree.config.Keys.*;
import static com.mongodb.MongoCredential.createCredential;
import static java.util.Collections.singletonList;

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
        MongoCredential credential = createCredential(config.property(MONGO_USERNAME), config.property(MONGO_DATABASE), config.property(MONGO_PASSWORD).toCharArray());
        MongoClient c = new MongoClient(new ServerAddress(config.property(MONGO_HOST), config.asInteger(MONGO_PORT)), singletonList(credential));
        return new MongoTemplate(new SimpleMongoDbFactory(c, config.property(MONGO_DATABASE)));
    }

    @Bean
    public AmazonS3Client amazonS3Client(){
        return new AmazonS3Client();
    }
}
