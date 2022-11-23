package com.Xbrain.BackendXbrain.exception;

public class UserException extends BaseExceptionImpl {
    public UserException(String errorCode) {
        super("user" + errorCode);
    }

    public  static  UserException userNotFound() {
        return new UserException("UserNotFound");
    }
    public  static  UserException emailnull() {
        return new UserException("register.email.null");
    }
    public static UserException createEmailNull() {
        return new UserException("create.email.null");
    }
    public static UserException createEmailDuplicated() {
        return new UserException("create.email.duplicated");
    }

    public static UserException notFound() {
        return new UserException("user.not.found");
    }
}
