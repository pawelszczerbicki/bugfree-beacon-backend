package com.bugfree;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 11.08.15.
 */
@RestController("/")
public class IndexController {

    @RequestMapping
    public String index(){
        return "";
    }
}
