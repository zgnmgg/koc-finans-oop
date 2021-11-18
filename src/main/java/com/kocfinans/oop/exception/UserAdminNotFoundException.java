package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class UserAdminNotFoundException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "NOT_FOUND.userAdmin";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public UserAdminNotFoundException() {
        super();
    }

    public UserAdminNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAdminNotFoundException(final String message) {
        super(message);
    }

    public UserAdminNotFoundException(final Throwable cause) {
        super(cause);
    }

}
