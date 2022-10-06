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
        entity.setName(dto.getName());
        entity.setAlias(dto.getAlias());
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
        dto.setName(entity.getName());
        dto.setAlias(entity.getAlias());
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

    public void partialUpdate(Organization entity, OrganizationDto dto){
        if (dto == null) {
            return;
        }
        if( dto.getId()!= null){
            entity.setId(dto.getId());
        }
        if( dto.getOrganizationName()!= null){
            entity.setOrganizationName(dto.getOrganizationName());
        }
        if( dto.getOrganizationAlias()!= null){
            entity.setOrganizationAlias(dto.getOrganizationAlias());
        }
        if( dto.getVAT()!= null){
            entity.setVAT(dto.getVAT());
        }
        if(dto.getRegistrationCode() != null){
            entity.setRegistrationCode(dto.getRegistrationCode());
        }
        if( dto.getTaxRegistrationCountry()!= null){
            entity.setTaxRegistrationCountry(dto.getTaxRegistrationCountry());
        }
        if( dto.getLegalAddressCountry()!= null){
            entity.setLegalAddressCountry(dto.getLegalAddressCountry());
        }
        if( dto.getLegalAddressCity()!= null){
            entity.setLegalAddressCity(dto.getLegalAddressCity());
        }
        if(dto.getLegalAddressStreet() != null){
            entity.setLegalAddressStreet(dto.getLegalAddressStreet());
        }
        if( dto.getLegalAddressZipcode()!= null){
            entity.setLegalAddressZipcode(dto.getLegalAddressZipcode());
        }
        if( dto.getContactPerson()!= null){
            entity.setContactPerson(dto.getContactPerson());
        }
    }

    public void update(Organization entity,OrganizationDto dto){
        if(dto == null){
            return;
        }
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAlias(dto.getAlias());
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
