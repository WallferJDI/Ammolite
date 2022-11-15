package com.knits.ammolite.mocks.model.common;


import com.knits.ammolite.model.common.Address;

public class AddressMock {
    public static Address getAddressAllFields(Long id){
        return Address.builder()
                .city("City name")
                .country(CountryMock.getCountryAllFields(id))
                .street("Street name")
                .zipCode("3344")
                .build();
    }
}
