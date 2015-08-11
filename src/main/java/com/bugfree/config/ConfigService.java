package com.bugfree.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.lang.System.getenv;

/**
 * Created by Pawel on 2014-07-23.
 */
@Service
public class ConfigService {

    @Autowired
    private Environment env;

    public String property(String key) {
        return getenv(key) == null ? env.getProperty(key) : getenv(key);
    }

    public Boolean asBoolean(String key){
        return parseBoolean(property(key));
    }

    public Integer asInteger(String key){
        return parseInt(property(key));
    }
}
