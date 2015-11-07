package com.bugfree.web.order;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel on 07.11.15.
 */
@Repository
public class OrderDao extends GenericDao<Order>{

    public OrderDao() {
        super(Order.class);
    }
}
