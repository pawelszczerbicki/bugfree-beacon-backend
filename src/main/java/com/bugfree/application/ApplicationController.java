package com.bugfree.application;

import com.bugfree.customer.CustomerService;
import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import com.bugfree.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by pawel on 18.08.15.
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/shapes")
    public JsonResponse<Shape[]> shapes() {
        return SuccessResponse.create(Shape.values());
    }

    @RequestMapping(value = {"/", "/{id}"}, method = {POST, PUT})
    public JsonResponse<Application> saveOrUpdate(Application a) {
        return SuccessResponse.create(customerService.save(a).orElseThrow(ResourceNotFoundException::new));
    }

    @RequestMapping(method = GET)
    public JsonResponse<Application> get() {
        return SuccessResponse.create(customerService.get().orElseThrow(ResourceNotFoundException::new).getApplication());
    }
}
