package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class UserClientAlreadyExistException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "CONFLICT.userClient.alreadyExist";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }

    public UserClientAlreadyExistException() {
        super();
    }

    public UserClientAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserClientAlreadyExistException(final String message) {
        super(message);
    }

    public UserClientAlreadyExistException(final Throwable cause) {
        super(cause);
    }
}
