package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class UserClientNotEnableException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "FORBIDDEN.userClient";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }

    @Override
    public int getErrorCode() {
        return 101;
    }

    public UserClientNotEnableException() {
        super();
    }

    public UserClientNotEnableException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserClientNotEnableException(final String message) {
        super(message);
    }

    public UserClientNotEnableException(final Throwable cause) {
        super(cause);
    }

}
