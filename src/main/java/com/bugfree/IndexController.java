package com.bugfree;

import com.bugfree.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 11.08.15.
 */
@RestController("/")
public class IndexController {

    @Autowired
    private DomainProvider provider;

    @RequestMapping
    public String index(){
        return provider.getDomain();
    }
}
