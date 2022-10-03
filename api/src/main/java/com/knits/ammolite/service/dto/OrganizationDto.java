package com.knits.ammolite.service.dto;

import com.knits.ammolite.model.ContactPerson;
import lombok.Data;

@Data
public class OrganizationDto {
    private Long id;
    private String organizationName;
    private String organizationAlias;
    private String VAT;
    private String registrationCode;
    private String taxRegistrationCountry;
    private String legalAddressCountry;
    private String legalAddressCity;
    private String legalAddressStreet;
    private String legalAddressZipcode;
    private ContactPerson contactPerson;

}
