package com.bugfree.customer;

import com.bugfree.application.Application;
import com.bugfree.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by pawel on 18.08.15.
 */
@Service
public class CustomerService {

    @Autowired
    private DomainProvider provider;

    @Autowired
    private CustomerDao dao;

    public Optional<Application> save(Application a) {
        Optional<Customer> maybe = dao.getByDomain(provider.getDomain());
        if (!maybe.isPresent())
            return Optional.empty();
        Customer customer = maybe.get();
        customer.setApplication(a);
        dao.save(customer);
        return Optional.of(customer.getApplication());
    }

    public Optional<Application> getApplication() {
        Optional<Customer> maybe = dao.getByDomain(provider.getDomain());
        return maybe.isPresent() ? Optional.ofNullable(maybe.get().getApplication()) : Optional.empty();
    }

    public Optional<Customer> find(String id) {
        return dao.findOne(id);
    }
}
