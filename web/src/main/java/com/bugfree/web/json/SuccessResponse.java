package com.bugfree.web.json;

/**
 * Created by pawel on 25.03.15.
 */
public class SuccessResponse<T> extends JsonResponse<T> {

    public static final String SUCCESS = "success";

    public SuccessResponse() {
        this(null);
    }

    private SuccessResponse(T data) {
        super(data);
    }

    public static <T> SuccessResponse<T> create(T data) {
        return new SuccessResponse<>(data);
    }

    public static <T> SuccessResponse<T> create() {
        return new SuccessResponse<>();
    }
}
