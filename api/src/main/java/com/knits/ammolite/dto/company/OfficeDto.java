package com.knits.ammolite.dto.company;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OfficeDto {
    private Long id;
    private String name;
    private String telephone;
    private String email;
}

