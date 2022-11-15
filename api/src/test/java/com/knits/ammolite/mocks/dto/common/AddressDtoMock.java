package com.knits.ammolite.mocks.dto.common;

import com.knits.ammolite.dto.common.AddressDto;

public class AddressDtoMock {


    public static AddressDto getAddressDtoAllFields(Long id){
        return AddressDto.builder()
                .city("City name")
                .country(CountryDtoMock.getCountryDtoAllFields(id))
                .street("Street name")
                .zipCode("3344")
                .build();
    }
}
