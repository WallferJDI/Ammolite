package com.knits.ammolite.dto.common;

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
public class OrganizationDto{

    @JsonView(Views.Public.class)
    private Long id;

    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String alias;

    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String vatNumber;

    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String registrationCode;

    @NotNull
    @JsonView(Views.Internal.class)
    private CountryDto taxRegistrationCountry;

    @NotNull
    @JsonView(Views.Internal.class)
    private AddressDto legalAddressCountry;

    @JsonView(Views.Internal.class)
    private ContactDto contactPerson;

    @Builder.Default
    @JsonView(Views.Internal.class)
    private boolean deleted = Boolean.FALSE;
}
