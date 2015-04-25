package com.bugfree.beacon;

import com.bugfree.json.FailResponse;
import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/beacon")
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
        if (b.isPresent() && service.addPhoto(b.get(), file))
            return SuccessResponse.create(b.get());
        else return FailResponse.create();
    }
}
