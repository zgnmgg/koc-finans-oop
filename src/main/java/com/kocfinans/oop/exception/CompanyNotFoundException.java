package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public final class CompanyNotFoundException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "NOT_FOUND.company";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public CompanyNotFoundException() {
        super();
    }

    public CompanyNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CompanyNotFoundException(final String message) {
        super(message);
    }

    public CompanyNotFoundException(final Throwable cause) {
        super(cause);
    }
}
