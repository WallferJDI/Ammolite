package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.RoleDto;

public class RoleDtoMock {
    public static RoleDto shallowRoleDto(Long id) {
        return RoleDto.builder()
                .id(id)
                .name("Role 1")
                .build();
    }
}
