package com.kocfinans.oop.service.impl.payment;

import com.kocfinans.oop.models.UserClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("creditCardPayment")
public class CreditCardPaymentService implements PaymentService {

    public void payment(UserClient userClient) {
        //TODO credit card integration or service send request
    }
}
