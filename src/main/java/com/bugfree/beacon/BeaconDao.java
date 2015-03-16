package com.bugfree.beacon;

import com.bugfree.generic.GenericDao;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class BeaconDao extends GenericDao<Beacon> {

    public BeaconDao() {
        super(Beacon.class);
    }

    public Beacon get(String uuid, Integer minor, Integer major) {
        return mongo.findOne(query(where("uuid").is(uuid).and("minor").is(minor).and("major").is(major)), clazz);
    }
}
