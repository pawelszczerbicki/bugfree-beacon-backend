package com.bugfree.application;

import com.bugfree.customer.CustomerService;
import com.bugfree.json.FailResponse;
import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

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
        return maybe.isPresent() ? SuccessResponse.create(maybe.get()) : FailResponse.create();
    }

    @RequestMapping(method = GET)
    public JsonResponse<Application> get() {
        Optional<Application> maybe = customerService.getApplication();
        return maybe.isPresent() ? SuccessResponse.create(maybe.get()) : FailResponse.create();
    }
}
