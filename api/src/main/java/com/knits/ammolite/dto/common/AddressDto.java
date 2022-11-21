package com.knits.ammolite.dto.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Views.Public.class)
public class AddressDto {

    @NotNull
    private CountryDto country;
    @NotEmpty
    @NotBlank
    private String city;
    @NotEmpty
    @NotBlank
    private String street;
    @NotEmpty
    @NotBlank
    private String zipCode;
}
