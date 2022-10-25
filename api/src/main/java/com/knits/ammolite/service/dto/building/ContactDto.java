package com.knits.ammolite.service.dto.building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
