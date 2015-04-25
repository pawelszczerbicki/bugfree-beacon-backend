package com.bugfree.beacon;

import com.bugfree.json.FailResponse;
import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.bugfree.config.Keys.BEACON_NOT_PRESENT;
import static com.bugfree.config.Keys.UPLOAD_ERROR;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/beacon")
public class BeaconController {
    private static final Logger logger = getLogger(BeaconController.class);
    @Autowired
    private BeaconService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Beacon> find(Beacon b) {
        return service.find(b.getUuid(), b.getMinor(), b.getMajor());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse get(@PathVariable String id) {
        Optional<Beacon> beacon = service.findOne(id);
        if (beacon.isPresent())
            return SuccessResponse.create(beacon.get());
        return FailResponse.create();
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public JsonResponse save(@RequestBody Beacon b) {
        service.save(b);
        return SuccessResponse.create(b);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseBody
    public JsonResponse update(@RequestBody Beacon b) {
        service.save(b);
        return SuccessResponse.create(b);
    }

    @RequestMapping(value = "/{id}/photo", method = POST)
    @ResponseBody
    public JsonResponse addPhoto(@PathVariable String id, MultipartFile file) {
        Optional<Beacon> b = service.findOne(id);
        if (!b.isPresent())
            return FailResponse.create(BEACON_NOT_PRESENT);
        else if (!service.addPhoto(b.get(), file))
            return FailResponse.create(UPLOAD_ERROR);
        else return SuccessResponse.create();
    }

    @RequestMapping("")
    @ResponseBody
    public String testLogger(){
        logger.error("test logger");
        return "test";
    }
}
