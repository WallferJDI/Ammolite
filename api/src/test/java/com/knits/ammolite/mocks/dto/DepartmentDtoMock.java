package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.DepartmentDto;

public class DepartmentDtoMock {

        public static DepartmentDto shallowDepartmentDto(Long id) {
            return DepartmentDto.builder()
                    .id(id)
                    .name("Mock Department"+id)
                    .build();
        }
}
