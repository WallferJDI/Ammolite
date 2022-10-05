package com.knits.ammolite.service;


import com.knits.ammolite.exceptions.OrganizationException;
import com.knits.ammolite.model.organization.Organization;
import com.knits.ammolite.repository.OrganizationRepository;
import com.knits.ammolite.service.dto.OrganizationDto;
import com.knits.ammolite.service.mapper.OrganizationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class OrganizationService {


    private final OrganizationMapper organizationMapper;
    private final OrganizationRepository organizationRepository;


    @Autowired
    public OrganizationService(OrganizationMapper organizationMapper, OrganizationRepository organizationRepository, CountryService countryService) {
        this.organizationMapper = organizationMapper;
        this.organizationRepository = organizationRepository;
    }



    public OrganizationDto save(OrganizationDto organizationDto){
        log.debug("Request to save Organization : {}", organizationDto);
        Organization organization = organizationMapper.toEntity(organizationDto);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }

    public OrganizationDto update(OrganizationDto organizationDto){
        log.debug("Request to update Organization : {}", organizationDto);
        Organization organization = organizationRepository.findById(organizationDto.getId())
                .orElseThrow(()-> new OrganizationException("Organization "+ organizationDto.getId() +" not exist"));
        organizationMapper.update(organization,organizationDto);
        organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }


}
