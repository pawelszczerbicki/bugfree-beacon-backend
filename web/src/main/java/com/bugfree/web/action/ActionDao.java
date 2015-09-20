package com.bugfree.web.action;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel on 19.09.15.
 */
@Repository
public class ActionDao extends GenericDao<Action> {

    public ActionDao() {
        super(Action.class);
    }
}
