package com.example.constant;

public enum SkillName {

    BAKERY(2.0),
    CHECKOUT_CASHIER(1.2),
    CUSTOMER_SERVICE(1.3),
    SHIFT_LEADER(3.0),
    SECURITY(1.0),
    CLEANING(1.0),
    DELIVERY_DRIVER(2.0);

    private final double rate;

    SkillName(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

}
