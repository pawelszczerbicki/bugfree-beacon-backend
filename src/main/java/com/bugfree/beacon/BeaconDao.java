package com.bugfree.beacon;

import com.bugfree.generic.GenericDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class BeaconDao extends GenericDao<Beacon> {

    public BeaconDao() {
        super(Beacon.class);
    }

    public List<Beacon> findByUuidAndOthersIfNotNull(String uuid, Integer minor, Integer major) {
        Criteria c = where("uuid").is(uuid);
        addIfNotNull(c, minor, "minor");
        addIfNotNull(c, major, "major");
        return mongo.find(query(c), clazz);
    }

    public List<Beacon> findByParametersList(List<Beacon> beacons) {
        List<String> uuids = beacons.stream().map(Beacon::getUuid).collect(Collectors.toList());
        List<Integer> minors = beacons.stream().map(Beacon::getMinor).collect(Collectors.toList());
        List<Integer> majors = beacons.stream().map(Beacon::getMajor).collect(Collectors.toList());

        Criteria c = where("uuid").all(uuids).and("minor").all(minors).and("major").all(majors);
        return mongo.find(query(c), clazz);
    }

    private void addIfNotNull(Criteria c, Object param, String name) {
        if (param != null)
            c.and(name).is(param);
    }
}
