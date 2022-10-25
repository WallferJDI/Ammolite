package com.knits.ammolite.service.dto.building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecurityContactDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
