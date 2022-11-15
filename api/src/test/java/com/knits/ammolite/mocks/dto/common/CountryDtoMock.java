package com.knits.ammolite.mocks.dto.common;

import com.knits.ammolite.dto.common.CountryDto;

public class CountryDtoMock {

    public static CountryDto getCountryDtoAllFields(Long id){
        return CountryDto.builder()
                .id(id)
                .name("Country Name")
                .iso2("Iso 2")
                .iso3("Iso 3")
                .build();
    }
}
