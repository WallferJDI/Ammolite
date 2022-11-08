package com.knits.ammolite.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DivisionDto {
    private Long id;
    @NotEmpty
    private String name;
}
