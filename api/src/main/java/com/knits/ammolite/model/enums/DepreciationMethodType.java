package com.knits.ammolite.model.enums;

public enum DepreciationMethodType {
    STRAIGHT("Straight Line"),
    DOUBLE("Double Declining"),
    SUM("Sum of the years"),
    UNITS("Units of Production")
    ;
    private final String text;

    DepreciationMethodType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
