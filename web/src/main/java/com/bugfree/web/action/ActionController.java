package com.bugfree.web.action;

import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by pawel on 17.09.15.
 */
@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService service;

    @RequestMapping(method = POST)
    public JsonResponse addActions(@RequestBody Action[] a) {
        return SuccessResponse.create(service.save(asList(a)));
    }
}
