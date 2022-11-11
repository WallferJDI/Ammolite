package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.dto.common.OrganizationDto;

public class OrganizationDtoMock {
    public static OrganizationDto shallowOrganizationDto(Long id) {
        return OrganizationDto.builder()
                .id(id)
                .name("Mock Organization"+id)
                .build();
    }
}
