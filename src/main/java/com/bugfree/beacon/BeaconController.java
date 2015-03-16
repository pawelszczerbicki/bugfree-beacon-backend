package com.bugfree.beacon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/beacon")
public class BeaconController {

    @Autowired
    private BeaconDao beaconDao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Beacon[] find(Beacon b) {
        return new Beacon[] { beaconDao.get(b.getUuid(), b.getMinor(), b.getMajor()) };
    }
}
