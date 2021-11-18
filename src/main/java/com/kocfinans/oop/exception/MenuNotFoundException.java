package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public class MenuNotFoundException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "NOT_FOUND.menu";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public MenuNotFoundException() {
        super();
    }

    public MenuNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MenuNotFoundException(final String message) {
        super(message);
    }

    public MenuNotFoundException(final Throwable cause) {
        super(cause);
    }
}
