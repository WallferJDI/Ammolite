package com.knits.ammolite.service.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active = true;
}
