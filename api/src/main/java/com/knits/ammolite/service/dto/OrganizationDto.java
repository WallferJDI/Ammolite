package com.knits.ammolite.service.dto;

import com.knits.ammolite.model.organization.ContactPerson;
import com.knits.ammolite.model.organization.Country;
import lombok.Data;

@Data
public class OrganizationDto {
    private Long id;
    private String organizationName;
    private String organizationAlias;
    private String VAT;
    private String registrationCode;
    private Country taxRegistrationCountry;
    private Country legalAddressCountry;
    private String legalAddressCity;
    private String legalAddressStreet;
    private String legalAddressZipcode;
    private ContactPerson contactPerson;


}
