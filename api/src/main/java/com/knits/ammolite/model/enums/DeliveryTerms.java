package com.knits.ammolite.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeliveryTerms {
    DAYS_7(7),
    DAYS_30(30),
    DAYS_60(60),
    DAYS_90(90),
    DAYS_120(120),
    DAYS_180(180);

    private final int value;
}
