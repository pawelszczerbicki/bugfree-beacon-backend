package com.bugfree;

import com.bugfree.beacon.Beacon;
import com.bugfree.beacon.BeaconDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pawel on 14.03.15.
 */
@Controller
@RequestMapping("/beacon")
public class MainController {

    @Autowired
    private BeaconDao beaconDao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Beacon some(Beacon b) {
        return beaconDao.get(b.getUuid(), b.getMinor(), b.getMajor());
    }
}
