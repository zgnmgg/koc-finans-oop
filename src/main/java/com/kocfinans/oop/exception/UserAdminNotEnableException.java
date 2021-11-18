package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class UserAdminNotEnableException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "FORBIDDEN.userAdmin";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }

    @Override
    public int getErrorCode() {
        return 107;
    }

    public UserAdminNotEnableException() {
        super();
    }

    public UserAdminNotEnableException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAdminNotEnableException(final String message) {
        super(message);
    }

    public UserAdminNotEnableException(final Throwable cause) {
        super(cause);
    }

}
