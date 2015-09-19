package com.bugfree.web;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pawel on 15.08.15.
 */
@Controller
@RequestMapping(value = "/doc")
public class DocumentationController extends ApiDocumentationController {

    public DocumentationController() {
        setBaseControllerPackage("com.bugfree");
        setApiVersion("v1");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String documentation() {
        return "documentation";
    }
}
