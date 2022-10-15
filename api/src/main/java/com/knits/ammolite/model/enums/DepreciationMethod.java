package com.knits.ammolite.model.enums;

public enum DepreciationMethod {
    STRAIGHT("Straight Line"),
    DOUBLE("Double Declining"),
    SUM("Sum of the years"),
    UNITS("Units of Production")
    ;
    private final String text;

    DepreciationMethod(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
