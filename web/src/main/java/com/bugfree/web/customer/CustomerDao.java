package com.bugfree.web.customer;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CustomerDao extends GenericDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

    public Optional<Customer> getByDomain(String domain) {
        return Optional.ofNullable(mongo.findOne(query(where("domain").is(domain)), clazz));
    }
}
