package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.dto.security.UserDto;

public class UserDtoMock {

    public static UserDto shallowUserDto(Long id) {

        return UserDto.builder()
                .id(id)
                .firstName("A mock firstName")
                .lastName("A mock lastName")
                .login("A mock username")
                .password("A mock password")
                .email("aMockName.aMockSurname@aMockDomain.com")
                .build();
    }
}
