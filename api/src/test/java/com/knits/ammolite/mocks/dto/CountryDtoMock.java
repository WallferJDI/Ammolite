package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.service.dto.location.CountryDto;

public class CountryDtoMock {

    public static CountryDto shallowCountryDto(Long id){

        return CountryDto.builder()
                .id(id)
                .title("A mock Title")
                .build();
    }

}
