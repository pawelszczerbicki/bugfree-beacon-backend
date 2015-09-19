package com.bugfree.web.stats;

import com.bugfree.web.beacon.domain.BeaconAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by pawel on 17.09.15.
 */
@RestController
@RequestMapping("beacons/{beaconId}/stats")
public class BeaconStatsController {

    @Autowired
    private StatsService service;

    @RequestMapping(method = GET)
    public List<BeaconAction> get(StatsRequest r) {
        return null;
    }
}
