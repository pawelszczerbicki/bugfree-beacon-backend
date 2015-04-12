package com.bugfree.customer;

import com.bugfree.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends GenericDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

}
