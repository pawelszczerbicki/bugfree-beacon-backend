package com.bugfree.web.translation;

import com.bugfree.web.generic.GenericDao;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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

    public List<Translation> findLangByDomain(String domain) {
        Query q = query(where("domain").is(domain));
        q.fields().include("languageCode").exclude("id");
        return mongo.find(q, clazz);
    }
}
