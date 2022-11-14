package com.knits.ammolite.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    private String name;
    private String alias;
    private String vatNumber;
    private String registrationCode;
    private CountryDto taxRegistrationCountry;
    private CountryDto legalAddressCountry;

    private ContactDto contactPerson;
    @Builder.Default
    private boolean deleted = Boolean.FALSE;
}
