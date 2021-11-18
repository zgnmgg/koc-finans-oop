package com.kocfinans.oop.models.enumerator;

public enum Payment {
    CASH, ONLINE, CREDIT_CARD, MEAL_TICKET;

    public String getName() {
        return name();
    }
}
