package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.dto.company.OfficeDto;

public class OfficeDtoMock {
    public static OfficeDto shallowOfficeDto(Long id) {
        return OfficeDto.builder()
                .id(id)
                .name("Mock Office"+id)
                .build();
    }
}
