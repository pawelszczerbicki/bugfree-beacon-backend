package com.bugfree.beacon;

import com.bugfree.json.FailResponse;
import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/beacon")
public class BeaconController {

    @Autowired
    private BeaconDao beaconDao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Beacon> find(Beacon b) {
        return beaconDao.findByUuidAndOthersIfNotNull(b.getUuid(), b.getMinor(), b.getMajor());
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse get(@PathVariable String id) {
        Optional<Beacon> beacon = beaconDao.findOne(id);
        if (beacon.isPresent())
            return SuccessResponse.create(beacon.get());
        return FailResponse.create();
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public JsonResponse save(Beacon b) {
        beaconDao.save(b);
        return SuccessResponse.create(b);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseBody
    public JsonResponse update(Beacon b) {
        beaconDao.save(b);
        return SuccessResponse.create(b);
    }
}
