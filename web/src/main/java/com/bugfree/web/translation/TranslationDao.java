package com.bugfree.web.translation;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by pawel on 21.09.15.
 */
@Repository
public class TranslationDao extends GenericDao<Translation> {
    public TranslationDao() {
        super(Translation.class);
    }

    public List<Translation> findByDomain(String domain) {
        return mongo.find(query(where("domain").is(domain)), clazz);
    }
}
