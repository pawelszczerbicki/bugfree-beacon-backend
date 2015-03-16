package com.bugfree.customer;

import com.bugfree.generic.GenericDao;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CustomerDao extends GenericDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

}
