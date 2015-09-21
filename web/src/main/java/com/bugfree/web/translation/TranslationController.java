package com.bugfree.web.translation;

import com.bugfree.web.json.JsonResponse;
import com.bugfree.web.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by pawel on 21.09.15.
 */
@RestController
@RequestMapping("/translations")
public class TranslationController {

    @Autowired
    private TranslationService service;

    @RequestMapping(method = GET)
    public JsonResponse<List<Translation>> get() {
        return SuccessResponse.create(service.getAll());
    }

    @RequestMapping(method = {PUT, POST})
    public JsonResponse<Translation> saveOrUpdate(@RequestBody Translation t) {
        return SuccessResponse.create(service.save(t));
    }
}
