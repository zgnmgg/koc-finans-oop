package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class CompanyNotEnableException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "FORBIDDEN.company";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }

    public CompanyNotEnableException() {
        super();
    }

    public CompanyNotEnableException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CompanyNotEnableException(final String message) {
        super(message);
    }

    public CompanyNotEnableException(final Throwable cause) {
        super(cause);
    }

}
