package com.knits.ammolite.dto.security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
public class UserDto {

    @EqualsAndHashCode.Include
    private Long id;

    private String login;

    @ToString.Exclude
    private String password;

    @EqualsAndHashCode.Include
    private String firstName;

    @EqualsAndHashCode.Include
    private String lastName;

    private String email;

    @Builder.Default
    private Boolean active = true;
}