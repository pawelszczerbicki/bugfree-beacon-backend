package com.bugfree.web.beacon;

import com.bugfree.web.beacon.domain.Beacon;
import com.bugfree.web.generic.GenericDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class BeaconDao extends GenericDao<Beacon> {

    public BeaconDao() {
        super(Beacon.class);
    }

    public List<Beacon> find(String uuid, Integer minor, Integer major) {
        Criteria c = new Criteria();
        addIfNotNull(c, uuid, "uuid");
        addIfNotNull(c, minor, "minor");
        addIfNotNull(c, major, "major");
        return mongo.find(query(c), clazz);
    }

    private void addIfNotNull(Criteria c, Object param, String name) {
        if (param != null) c.and(name).is(param);
    }
}
