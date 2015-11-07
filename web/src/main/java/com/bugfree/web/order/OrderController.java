package com.bugfree.web.order;

import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by pawel on 07.11.15.
 */

@RestController
@RequestMapping("/orders")
public class OrderController {

    public static final double TAX = 0.22d;

    @Autowired
    private OrderService service;

    @RequestMapping(method = GET)
    public JsonResponse<List<Order>> orders() {
        return SuccessResponse.create(service.all());
    }

    @RequestMapping(value = "/calculate", method = GET)
    public JsonResponse<Calculation> calculate(Calculation c) {
        return SuccessResponse.create(c.withPrice(c.getAmount() * 101.33d).calculateTax(TAX));
    }

    @RequestMapping(method = {PUT, POST})
    public JsonResponse<Order> save(@RequestBody Order order) {
        return SuccessResponse.create(service.save(order));
    }
}
