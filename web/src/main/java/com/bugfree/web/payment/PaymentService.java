package com.bugfree.web.payment;

import com.bugfree.web.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pawel on 22.09.15.
 */
@Service
public class PaymentService {

    @Autowired
    private DomainProvider provider;

    @Autowired
    private PaymentDao dao;

    public List<Payment> getAll() {
        return dao.findByDomain(provider.getDomain());
    }

    //TODO remove. Only for dev purposes
    public Payment save(Payment p) {
        p.setDomain(provider.getDomain());
        return dao.save(p);
    }
}
