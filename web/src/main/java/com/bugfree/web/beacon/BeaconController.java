package com.bugfree.web.beacon;

import com.bugfree.web.beacon.domain.Beacon;
import com.bugfree.web.json.FailResponse;
import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import com.bugfree.web.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.bugfree.commons.config.Keys.BEACON_NOT_PRESENT;
import static com.bugfree.commons.config.Keys.UPLOAD_ERROR;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/beacons")
public class BeaconController {

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
        return SuccessResponse.create(service.findOne(id).orElseThrow(ResourceNotFoundException::new));
    }

    @RequestMapping(value = {"", "/{id}"}, method = {POST, PUT})
    @ResponseBody
    public JsonResponse<Beacon> saveOrUpdate(@RequestBody Beacon b) {
        return SuccessResponse.create(service.save(b));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseBody
    public JsonResponse delete(@PathVariable String id) {
        service.delete(id);
        return SuccessResponse.create();
    }

    @RequestMapping(value = "/{id}/photo", method = POST)
    @ResponseBody
    public JsonResponse addPhoto(@PathVariable String id, MultipartFile file) {
        Optional<Beacon> b = service.findOne(id);
        if (!b.isPresent()) return FailResponse.create(BEACON_NOT_PRESENT);
        else if (!service.addPhoto(b.get(), file)) return FailResponse.create(UPLOAD_ERROR);
        else return SuccessResponse.create();
    }
}
