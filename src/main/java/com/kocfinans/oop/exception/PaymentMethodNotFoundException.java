package com.kocfinans.oop.exception;

import org.springframework.http.HttpStatus;

public class PaymentMethodNotFoundException extends RuntimeExceptionImp {

    @Override
    public String getMessageKey() {
        return "NOT_FOUND.paymentMethod";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public PaymentMethodNotFoundException() {
        super();
    }

    public PaymentMethodNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PaymentMethodNotFoundException(final String message) {
        super(message);
    }

    public PaymentMethodNotFoundException(final Throwable cause) {
        super(cause);
    }
}
