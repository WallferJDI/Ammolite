package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.EmployeeDto;

public class SolidLineManagerDtoMock {
    public static EmployeeDto shallowSolidLineManagerDto(Long id){
        return EmployeeDto.builder()
                .id(id)
                .firstName("Solid Line Manager")
                .lastName("Solid Line Manager")
                .build();
    }
}
