package com.knits.ammolite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoleDto {
    private Long id;
    @NotEmpty
    private String name;
}
