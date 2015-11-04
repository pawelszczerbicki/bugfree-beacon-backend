package com.bugfree.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 05.11.15.
 */
@RestController
public class FacebookController {

    @Autowired
    Facebook facebook;

    @RequestMapping(value = "/api/facebook/details", method = RequestMethod.GET)
    public org.springframework.social.facebook.api.User getSocialDetails() {
        return facebook.userOperations().getUserProfile();
    }
}
