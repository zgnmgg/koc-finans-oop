package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class UserAdminAlreadyExistsException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "CONFLICT.userAdmin.alreadyExist";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }

    public UserAdminAlreadyExistsException() {
        super();
    }

    public UserAdminAlreadyExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAdminAlreadyExistsException(final String message) {
        super(message);
    }

    public UserAdminAlreadyExistsException(final Throwable cause) {
        super(cause);
    }
}
