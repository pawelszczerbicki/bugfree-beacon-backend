package com.bugfree.web.utils;

import com.bugfree.web.json.FailResponse;
import com.bugfree.web.json.JsonResponse;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

import static com.bugfree.commons.config.Keys.INTERNAL_SERVER_ERROR;
import static com.bugfree.commons.config.Keys.NOT_FOUND;
import static java.lang.String.format;
import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by pawel on 19.08.15.
 */
@ControllerAdvice
@ResponseBody
public class ErrorHandler {

    private static final String ERROR_ID_HEADER = "error-id";
    private final Logger logger = getLogger(getClass());

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public JsonResponse handleNotFound(ResourceNotFoundException ex) {
        return FailResponse.create(NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResponse handleException(Exception ex, HttpServletResponse response) {
        String code = randomAlphabetic(10);
        logger.error(format("Error 500, code [%s]", code), ex);
        response.addHeader(ERROR_ID_HEADER, code);
        return FailResponse.create(format(INTERNAL_SERVER_ERROR, code, ex.getMessage()));
    }
}
