package com.bugfree.beacon;

import com.bugfree.beacon.domain.Beacon;
import com.bugfree.generic.GenericDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class BeaconDao extends GenericDao<Beacon> {

    public BeaconDao() {
        super(Beacon.class);
    }

    public List<Beacon> find(String uuid, Integer minor, Integer major) {
        Criteria c = where("uuid").is(uuid);
        addIfNotNull(c, minor, "minor");
        addIfNotNull(c, major, "major");
        return mongo.find(query(c), clazz);
    }

    private void addIfNotNull(Criteria c, Object param, String name) {
        if (param != null) c.and(name).is(param);
    }
}
