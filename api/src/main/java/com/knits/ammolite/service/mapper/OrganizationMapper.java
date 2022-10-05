package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.organization.Organization;
import com.knits.ammolite.service.dto.OrganizationDto;
import org.springframework.stereotype.Component;


@Component
public class OrganizationMapper {


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
