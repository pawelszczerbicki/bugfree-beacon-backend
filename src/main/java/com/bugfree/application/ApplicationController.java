package com.bugfree.application;

import com.bugfree.json.JsonResponse;
import com.bugfree.json.SuccessResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 18.08.15.
 */
@RestController
public class ApplicationController {

    @RequestMapping("/shapes")
    public JsonResponse<Shape[]> shapes() {
        return SuccessResponse.create(Shape.values());
    }
}
