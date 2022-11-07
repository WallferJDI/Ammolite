package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.BusinessUnitDto;

public class BusinessUnitDtoMock {

    public static BusinessUnitDto shallowBusinessUnitDto(Long id) {
        return BusinessUnitDto.builder()
                .id(id)
                .name("Mock Business Unit"+id)
                .build();
    }
}
