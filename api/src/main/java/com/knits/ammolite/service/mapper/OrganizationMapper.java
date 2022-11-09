/*
package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.company.Organization;
import com.knits.ammolite.service.dto.OrganizationDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrganizationMapper {


    @InheritInverseConfiguration
    Organization toEntity(OrganizationDto dto);

    OrganizationDto toDto(Organization entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Organization entity, OrganizationDto dto);

    void update( @MappingTarget Organization entity, OrganizationDto dto);

<<<<<<< HEAD
}
=======

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
*/
>>>>>>> origin/S2-Maksim
