package com.bugfree.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.Duration.between;

/**
 * Created by pawel on 19.09.15.
 */
@Service
public class ActionService {

    @Autowired
    private ActionDao dao;

    public List<Action> save(List<Action> a) {
        a.stream().filter(e ->  e.getDateFrom() != null && e.getDateTo() != null)
                .forEach(e->e.setDurationInSeconds(between(e.getDateFrom(), e.getDateTo()).getSeconds()));
        return dao.saveAll(a);
    }
}
