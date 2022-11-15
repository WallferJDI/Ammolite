package com.knits.ammolite.mocks.dto.common;


import com.knits.ammolite.dto.common.OrganizationDto;



public class OrganizationDtoMock {

    public static OrganizationDto getAllFieldsOrganizationDto(Long id){
        return OrganizationDto.builder()
                .id(id)
                .name("OrgName "+id)
                .alias("Alias Text")
                .vatNumber("77-22-11-22")
                .registrationCode("8811234")
                .legalAddressCountry(AddressDtoMock.getAddressDtoAllFields(id))
                .taxRegistrationCountry(CountryDtoMock.getCountryDtoAllFields(id))
                .contactPerson(ContactPersonDtoMock.getContactPersonDtoAllFields(id))
                .deleted(false)
                .build();


    }
}
