package com.bugfree.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by pawel on 25.03.15.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FailResponse.class, name = FailResponse.FAIL),
        @JsonSubTypes.Type(value = SuccessResponse.class, name = SuccessResponse.SUCCESS),
})
public abstract class JsonResponse<T> {

    private T data;

    public JsonResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
