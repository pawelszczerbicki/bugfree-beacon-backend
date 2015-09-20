package com.bugfree.web.customer;

import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = GET)
    public JsonResponse<Customer> find() {
        return SuccessResponse.create(service.get());
    }

    @RequestMapping(value = "/invoice-data", method = GET)
    public JsonResponse<InvoiceData> invoice() {
        return SuccessResponse.create(service.get().getInvoiceData());
    }

    @RequestMapping(value = "/invoice-data", method = {POST, PUT})
    public JsonResponse<InvoiceData> updateInvoice(InvoiceData data) {
        return SuccessResponse.create(service.updateInvoice(data));
    }

}
