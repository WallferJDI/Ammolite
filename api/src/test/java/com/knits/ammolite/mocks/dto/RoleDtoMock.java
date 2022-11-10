package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.dto.RoleDto;

public class RoleDtoMock {
    public static RoleDto shallowRoleDto(Long id) {
        return RoleDto.builder()
                .id(id)
                .name("Mock Role"+id)
                .build();
    }
}
