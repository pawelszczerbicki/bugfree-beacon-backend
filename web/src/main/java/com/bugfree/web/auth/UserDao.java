package com.bugfree.web.auth;

import com.bugfree.web.generic.GenericDao;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by pawel on 05.11.15.
 */
@Repository
public class UserDao extends GenericDao<User> {
    public UserDao() {
        super(User.class);
    }

    public User findByUsername(String option) {
        return mongo.findOne(query(where("username").is(option)), clazz);
    }

    public User findByProviderIdAndProviderUserId(String providerId, String providerUserId) {
        return mongo.findOne(query(where("providerId").is(providerId).and("providerUserId").is(providerUserId)), clazz);
    }
}
