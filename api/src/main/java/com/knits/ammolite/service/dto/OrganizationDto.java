package com.knits.ammolite.service.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrganizationDto {
    private Long id;
    @NotEmpty
    private String name;
}

