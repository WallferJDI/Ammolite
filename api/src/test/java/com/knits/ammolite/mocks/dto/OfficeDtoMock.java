package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.OfficeDto;

public class OfficeDtoMock {
    public static OfficeDto shallowOfficeDto(Long id) {
        return OfficeDto.builder()
                .id(id)
                .name("Office 1")
                .build();
    }
}
