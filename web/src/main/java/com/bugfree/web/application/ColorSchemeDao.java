package com.bugfree.web.application;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ColorSchemeDao extends GenericDao<ColorScheme> {

    public ColorSchemeDao() {
        super(ColorScheme.class);
    }
}
