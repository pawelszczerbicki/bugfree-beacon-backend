package com.bugfree.web.translation;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel on 21.09.15.
 */
@Repository
public class TranslationDao extends GenericDao<Translation> {
    public TranslationDao() {
        super(Translation.class);
    }
}
