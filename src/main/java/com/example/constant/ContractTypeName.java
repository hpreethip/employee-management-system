package com.example.constant;

public enum ContractTypeName {

    PERMANENT(12.5),
    AGENCY(13.0),
    ZERO_HOURS(13.0);

    private final double rate;

    ContractTypeName(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

}
