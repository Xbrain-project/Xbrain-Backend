package com.Xbrain.BackendXbrain.exception;

public class UserException extends BaseException{
    public UserException(String errorCode) {
        super("user" + errorCode);
    }

    public  static  UserException userNotFound() {
        return new UserException("UserNotFound");
    }
    public  static  UserException emailnull() {
        return new UserException("register.email.null");
    }
}
