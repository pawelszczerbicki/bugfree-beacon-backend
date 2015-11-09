package com.bugfree.commons;

import com.bugfree.commons.config.ConfigService;
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

import java.net.UnknownHostException;

import static com.bugfree.commons.config.Keys.*;
import static com.bugfree.commons.config.Keys.MONGO_DATABASE;
import static com.bugfree.commons.config.Keys.MONGO_PORT;
import static com.mongodb.MongoCredential.createCredential;
import static java.util.Collections.singletonList;

/**
 * Created by pawel on 19.09.15.
 */
@Configuration
@ComponentScan(basePackages = "com.bugfree.commons")
@PropertySource(name="appProperties", value= "classpath:system.properties")
public class Config {

    @Autowired
    private ConfigService config;

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoCredential credential = createCredential(config.get(MONGO_USERNAME), config.get(MONGO_DATABASE), config.get(MONGO_PASSWORD).toCharArray());
        MongoClient c = new MongoClient(new ServerAddress(config.get(MONGO_HOST), config.asInteger(MONGO_PORT)), singletonList(credential));
        return new MongoTemplate(new SimpleMongoDbFactory(c, config.get(MONGO_DATABASE)));
    }
}
