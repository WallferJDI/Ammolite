package com.knits.ammolite.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private Long id;
    @NotEmpty
    @NotBlank
    private String name;
    private String alias;
    @NotEmpty
    @NotBlank
    private String vatNumber;
    @NotEmpty
    @NotBlank
    private String registrationCode;
    @NotNull
    private CountryDto taxRegistrationCountry;
    @NotNull
    private AddressDto legalAddressCountry;

    private ContactDto contactPerson;
    @Builder.Default
    private boolean deleted = Boolean.FALSE;
}
