package com.bugfree.web.order;

import com.bugfree.web.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pawel on 07.11.15.
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DomainProvider provider;

    public Order save(Order o){
        o.setDomain(provider.getDomain());
        return orderDao.save(o);
    }

    public List<Order> all(){
        return orderDao.findByDomain(provider.getDomain());
    }
}
