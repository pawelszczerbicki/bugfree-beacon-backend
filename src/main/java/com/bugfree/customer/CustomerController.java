package com.bugfree.customer;

import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import com.bugfree.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResponse<Customer> find(@PathVariable String id) {
        Optional<Customer> c = service.find(id);
        if (c.isPresent())
            return SuccessResponse.create(c.get());
        throw new ResourceNotFoundException();
    }
}
