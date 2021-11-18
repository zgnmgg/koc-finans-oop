package com.kocfinans.oop.service.impl.payment;

import com.kocfinans.oop.models.UserClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("onlinePayment")
public class OnlinePaymentService implements PaymentService {

    @Override
    public void payment(UserClient userClient) {
        //TODO online payment
    }
}
