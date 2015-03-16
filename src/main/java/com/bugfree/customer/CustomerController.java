package com.bugfree.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Customer[] find(String id) {
        return new Customer[] { customerDao.findOne(id) };
    }
}
