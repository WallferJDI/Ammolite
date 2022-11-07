package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.DivisionDto;

public class DivisionDtoMock {
    public static DivisionDto shallowDivisionDto(Long id) {
        return DivisionDto.builder()
                .id(id)
                .name("Mock Division"+id)
                .build();
    }
}
