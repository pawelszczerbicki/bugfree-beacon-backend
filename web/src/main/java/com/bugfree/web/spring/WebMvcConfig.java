package com.bugfree.web.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by pawel on 11.08.15.
 */
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //TODO temporary disabled mapper, add after new swagger version
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(new ScalaObjectMapper());
        converters.add(converter);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //TODO add allowed origins after test phase
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "HEAD", "DELETE");
    }
}
