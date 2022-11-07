package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.BusinessUnitDto;

public class BusinessUnitDtoMock {

    public static BusinessUnitDto shallowBusinessUnitDto(Long id) {
        return BusinessUnitDto.builder()
                .id(id)
                .name("Business Unit 1")
                .build();
    }
}
