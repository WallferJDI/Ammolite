package com.knits.ammolite.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    private Long id;
    private String iso2;
    private String iso3;
    private String name;
}
