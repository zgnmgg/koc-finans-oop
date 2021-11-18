package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class UserClientNotFoundException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "NOT_FOUND.userClient";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public UserClientNotFoundException() {
        super();
    }

    public UserClientNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserClientNotFoundException(final String message) {
        super(message);
    }

    public UserClientNotFoundException(final Throwable cause) {
        super(cause);
    }

}
