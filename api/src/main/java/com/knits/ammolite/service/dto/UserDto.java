package com.knits.ammolite.service.dto;

import com.knits.ammolite.annotations.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    @ValidEmail
    private String email;
    private Boolean active = true;
}
