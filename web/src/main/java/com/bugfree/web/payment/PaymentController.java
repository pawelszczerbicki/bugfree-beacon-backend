package com.bugfree.web.payment;

import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by pawel on 22.09.15.
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @RequestMapping(method = GET)
    public JsonResponse<List<Payment>> payments() {
        return SuccessResponse.create(service.getAll());
    }

    //TODO remove. Only for dev purposes
    @RequestMapping(method = {POST, PUT})
    public JsonResponse<Payment> save(@RequestBody Payment p) {
        return SuccessResponse.create(service.save(p));
    }
}
