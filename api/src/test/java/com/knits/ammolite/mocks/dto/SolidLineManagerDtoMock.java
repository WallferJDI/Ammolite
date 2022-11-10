package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.dto.company.EmployeeDto;

public class SolidLineManagerDtoMock {
    public static EmployeeDto shallowSolidLineManagerDto(Long id){
        return EmployeeDto.builder()
                .id(id)
                .firstName(EmployeeDtoMock.shallowEmployeeDto(id).getFirstName())
                .lastName(EmployeeDtoMock.shallowEmployeeDto(id).getLastName())
                .build();
    }
}
