package com.bugfree.web.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by pawel on 22.09.15.
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @RequestMapping(method = GET)
    public List<Payment> payments() {
        return service.getAll();
    }
}
