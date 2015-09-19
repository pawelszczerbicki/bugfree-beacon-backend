package com.bugfree.web.utils;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by pawel on 19.08.15.
 */
@ResponseStatus(NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}
