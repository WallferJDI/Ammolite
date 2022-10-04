package com.knits.ammolite.payload;

import com.knits.ammolite.annotations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateOrganizationRequest {

    @NotEmpty(message = "This field is required")
    private String organizationName;

    private String organizationAlias;

    @NotEmpty(message = "This field is required")
    private String VAT;

    @NotEmpty(message = "This field is required")
    private String registrationCode;

    @NotEmpty(message = "This field is required")
    private String taxRegistrationCountry;

    @NotEmpty(message = "This field is required")
    private String legalAddressCountry;

    @NotEmpty(message = "This field is required")
    private String legalAddressCity;

    @NotEmpty(message = "This field is required")
    private String legalAddressStreet;

    @NotEmpty(message = "This field is required")
    private String legalAddressZipcode;

    private String firstNameContactPerson;

    private String lastNameContactPerson;

    @Email(message = "Check email format")
    @ValidEmail
    private String emailContactPerson;

    private String phoneNumberContactPerson;

    private String jobTitleContactPerson;

    private String noteContactPerson;



}
