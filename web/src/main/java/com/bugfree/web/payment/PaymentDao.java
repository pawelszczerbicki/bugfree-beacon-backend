package com.bugfree.web.payment;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel on 22.09.15.
 */
@Repository
public class PaymentDao extends GenericDao<Payment> {
    public PaymentDao() {
        super(Payment.class);
    }
}
