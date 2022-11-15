package com.knits.ammolite.mocks.model.common;

import com.knits.ammolite.model.common.Organization;

public class OrganizationMock {

    public static Organization getAllFieldsOrganization(Long id){
        return Organization.builder()
                .id(id)
                .name("OrgName "+id)
                .alias("Alias Text")
                .vatNumber("77-22-11-22")
                .registrationCode("8811234")
                .legalAddressCountry(AddressMock.getAddressAllFields(id))
                .taxRegistrationCountry(CountryMock.getCountryAllFields(id))
                .contactPerson(ContactPersonMock.getContactPersonAllFields(id))
                .deleted(false)
                .build();


    }
}
