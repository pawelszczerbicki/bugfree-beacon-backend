package com.bugfree.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pawel on 18.08.15.
 */
@Service
public class DomainProvider {

    @Autowired(required = false)
    private HttpServletRequest request;

    public String getDomain(){
        if(request == null)
            throw new IllegalStateException("Domain from outside request is not implemented yet");
        return request.getServerName();
    }
}
