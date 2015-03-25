package com.bugfree.json;

/**
 * Created by pawel on 25.03.15.
 */
public abstract class JsonResponse<T> {

    private T data;

    public JsonResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
