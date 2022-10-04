package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.organization.ContactPerson;
import com.knits.ammolite.model.organization.Organization;
import com.knits.ammolite.payload.CreateOrganizationRequest;
import com.knits.ammolite.service.CountryService;
import com.knits.ammolite.service.dto.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrganizationMapper {
    private final CountryService countryService;

    @Autowired
    public OrganizationMapper(CountryService countryService) {
        this.countryService = countryService;
    }

    public Organization toEntity(OrganizationDto dto){
        if (dto == null) {
            return null;
        }
        Organization entity = new Organization();
        entity.setId(dto.getId());
        entity.setOrganizationName(dto.getOrganizationName());
        entity.setOrganizationAlias(dto.getOrganizationAlias());
        entity.setVAT(dto.getVAT());
        entity.setRegistrationCode(dto.getRegistrationCode());
        entity.setTaxRegistrationCountry(dto.getTaxRegistrationCountry());
        entity.setLegalAddressCountry(dto.getLegalAddressCountry());
        entity.setLegalAddressCity(dto.getLegalAddressCity());
        entity.setLegalAddressStreet(dto.getLegalAddressStreet());
        entity.setLegalAddressZipcode(dto.getLegalAddressZipcode());
        entity.setContactPerson(dto.getContactPerson());
        return  entity;
    }

    public OrganizationDto requestToDto(CreateOrganizationRequest request){
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationName(request.getOrganizationName());
        organizationDto.setOrganizationAlias(request.getOrganizationAlias());
        organizationDto.setVAT(request.getVAT());
        organizationDto.setRegistrationCode(request.getRegistrationCode());
        organizationDto.setLegalAddressCity(request.getLegalAddressCity());
        organizationDto.setLegalAddressStreet(request.getLegalAddressStreet());
        organizationDto.setLegalAddressZipcode(request.getLegalAddressZipcode());

        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirstName(request.getFirstNameContactPerson());
        contactPerson.setLastName(request.getLastNameContactPerson());
        contactPerson.setPhoneNumber(request.getPhoneNumberContactPerson());
        contactPerson.setEmail(request.getEmailContactPerson());
        contactPerson.setJobTitle(request.getJobTitleContactPerson());
        contactPerson.setNote(request.getNoteContactPerson());

        organizationDto.setContactPerson(contactPerson);

        organizationDto.setTaxRegistrationCountry(
                countryService.getCountryByName(request.getTaxRegistrationCountry())
        );
        organizationDto.setLegalAddressCountry(
                countryService.getCountryByName(request.getLegalAddressCountry())
        );
        return  organizationDto;
    }

    public OrganizationDto toDto(Organization entity){
        if (entity == null) {
            return null;
        }
        OrganizationDto dto = new OrganizationDto();
        dto.setId(entity.getId());
        dto.setOrganizationName(entity.getOrganizationName());
        dto.setOrganizationAlias(entity.getOrganizationAlias());
        dto.setVAT(entity.getVAT());
        dto.setRegistrationCode(entity.getRegistrationCode());
        dto.setTaxRegistrationCountry(entity.getTaxRegistrationCountry());
        dto.setLegalAddressCountry(entity.getLegalAddressCountry());
        dto.setLegalAddressCity(entity.getLegalAddressCity());
        dto.setLegalAddressStreet(entity.getLegalAddressStreet());
        dto.setLegalAddressZipcode(entity.getLegalAddressZipcode());
        dto.setContactPerson(entity.getContactPerson());
        return dto;
    }

    public void update(Organization entity,OrganizationDto dto){
        if(dto == null){
            return;
        }
        entity.setId(dto.getId());
        entity.setOrganizationName(dto.getOrganizationName());
        entity.setOrganizationAlias(dto.getOrganizationAlias());
        entity.setVAT(dto.getVAT());
        entity.setRegistrationCode(dto.getRegistrationCode());
        entity.setTaxRegistrationCountry(dto.getTaxRegistrationCountry());
        entity.setLegalAddressCountry(dto.getLegalAddressCountry());
        entity.setLegalAddressCity(dto.getLegalAddressCity());
        entity.setLegalAddressStreet(dto.getLegalAddressStreet());
        entity.setLegalAddressZipcode(dto.getLegalAddressZipcode());
        entity.setContactPerson(dto.getContactPerson());
    }

}
