package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "NOT_FOUND.order";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public OrderNotFoundException() {
        super();
    }

    public OrderNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public OrderNotFoundException(final String message) {
        super(message);
    }

    public OrderNotFoundException(final Throwable cause) {
        super(cause);
    }
}
