package com.bugfree.application;

import com.bugfree.customer.CustomerService;
import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import com.bugfree.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @RequestMapping(method = {POST, PUT})
    public JsonResponse<Application> save(Application a) {
        Optional<Application> maybe = customerService.save(a);
        if (maybe.isPresent())
            return SuccessResponse.create(maybe.get());
        throw new ResourceNotFoundException();
    }

    @RequestMapping(method = GET)
    public JsonResponse<Application> get() {
        Optional<Application> maybe = customerService.getApplication();
        if (maybe.isPresent())
            return SuccessResponse.create(maybe.get());
        throw new ResourceNotFoundException();
    }
}
