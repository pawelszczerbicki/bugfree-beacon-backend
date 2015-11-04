package com.bugfree.web.application;

import com.bugfree.web.customer.CustomerService;
import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by pawel on 18.08.15.
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = {"/", "/{id}"}, method = {POST, PUT})
    public JsonResponse<Application> saveOrUpdate(@RequestBody Application a) {
        return SuccessResponse.create(customerService.save(a));
    }

    @RequestMapping(value = "/shape", method = POST)
    public JsonResponse<Application> saveShape(@RequestBody Shape shape) {
        return SuccessResponse.create(applicationService.addShape(shape));
    }

    @RequestMapping(value = "/appearance", method = POST)
    public JsonResponse<Application> saveAppearance(@RequestBody Appearance appearance) {
        return SuccessResponse.create(applicationService.addAppearance(appearance));
    }

    @RequestMapping(value = "/arrange", method = POST)
    public JsonResponse<Application> saveArrange(@RequestBody ArrangeType arrangeType) {
        return SuccessResponse.create(applicationService.addArrange(arrangeType));
    }

    @RequestMapping(value = "/logo", method = POST)
    public JsonResponse<Application> addLogo(MultipartFile file) {
        return SuccessResponse.create(applicationService.addLogo(file));
    }

    @RequestMapping(method = GET)
    public JsonResponse<ApplicationResponse> get() {
        return SuccessResponse.create(new ApplicationResponse(customerService.get().getApplication(),
                applicationService.getColorSchemes()));
    }

    //TODO remove - only for dev purposes
    @RequestMapping(value = "/scheme", method = POST)
    public JsonResponse<ApplicationResponse> saveScheme(@RequestBody ColorScheme scheme) {
        applicationService.save(scheme);
        return SuccessResponse.create();
    }
}
