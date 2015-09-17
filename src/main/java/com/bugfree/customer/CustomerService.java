package com.bugfree.customer;

import com.bugfree.application.Application;
import com.bugfree.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

/**
 * Created by pawel on 18.08.15.
 */
@Service
public class CustomerService {

    @Autowired
    private DomainProvider provider;

    @Autowired
    private CustomerDao dao;

    public Optional<Customer> get() {
        return dao.getByDomain(provider.getDomain());
    }

    public Optional<Application> save(Application a) {
        Optional<Customer> maybe = get();
        return maybe.isPresent() ? ofNullable(dao.save(maybe.get().withApplication(a)).getApplication()) : empty();
    }

    public Optional<InvoiceData> updateInvoice(InvoiceData d) {
        Optional<Customer> maybe = get();
        return maybe.isPresent() ? ofNullable(dao.save(maybe.get().withInvoiceData(d)).getInvoiceData()) : empty();
    }
}
