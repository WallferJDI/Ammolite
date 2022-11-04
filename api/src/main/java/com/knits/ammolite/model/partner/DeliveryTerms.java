package com.knits.ammolite.model.partner;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeliveryTerms {
    A(7),
    B(30),
    C(60),
    D(90),
    E(120),
    F(180);

    private final int value;
}
