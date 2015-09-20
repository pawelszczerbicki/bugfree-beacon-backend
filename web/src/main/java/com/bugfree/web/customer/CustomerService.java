package com.bugfree.web.customer;

import com.bugfree.web.application.Application;
import com.bugfree.web.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

/**
 * Created by pawel on 18.08.15.
 */
@Service
public class CustomerService {

    @Autowired
    private DomainProvider provider;

    @Autowired
    private CustomerDao dao;

    public Customer get() {
        return dao.getByDomain(provider.getDomain()).orElseThrow(() -> new IllegalArgumentException(format("Customer with domain [%s] does not exist", provider.getDomain())));
    }

    public Application save(Application a) {
        return dao.save(get().withApplication(a)).getApplication();
    }

    public InvoiceData updateInvoice(InvoiceData d) {
        return dao.save(get().withInvoiceData(d)).getInvoiceData();
    }
}
