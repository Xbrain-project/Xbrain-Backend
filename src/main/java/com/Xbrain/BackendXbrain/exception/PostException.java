package com.Xbrain.BackendXbrain.exception;


public class PostException extends BaseException {

    public PostException(String code) {
        super("product." + code);
    }

    public static PostException notFound() {
        return new PostException("not.found");
    }

    public static PostException createContentNull() {
        return new PostException("create.content.null");
    }

}
