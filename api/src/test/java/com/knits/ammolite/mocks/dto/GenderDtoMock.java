package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.GenderDto;

public class GenderDtoMock {
    public static GenderDto shallowGenderDto(Long id) {
        return GenderDto.MALE;
    }
}
