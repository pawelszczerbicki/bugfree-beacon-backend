package com.bugfree.web;

import com.bugfree.web.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by pawel on 11.08.15.
 */
@RestController
public class IndexController {

    @Autowired
    private DomainProvider provider;

    @RequestMapping(value = "/", method = GET)
    public String index(){
        return provider.getDomain();
    }
}
