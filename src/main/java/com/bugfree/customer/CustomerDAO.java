package com.bugfree.customer;

import com.bugfree.generic.GenericDao;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CustomerDAO extends GenericDao<Customer> {

    public CustomerDAO() {
        super(Customer.class);
    }

    public Customer get(String id) {
        return mongo.findOne(query(where("id").is(id)), clazz);
    }
}
