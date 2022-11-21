package com.knits.ammolite.dto.common;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Views.Public.class)
public class CountryDto {

    private Long id;
    private String iso2;
    private String iso3;

    @NotEmpty
    @NotBlank
    private String name;
}
