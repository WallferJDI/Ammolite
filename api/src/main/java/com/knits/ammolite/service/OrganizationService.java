package com.knits.ammolite.service;


import com.knits.ammolite.model.Organization;
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

    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationDto save(OrganizationDto organizationDto){
        log.debug("Request to save Organization : {}", organizationDto);
        Organization organization = organizationMapper.toEntity(organizationDto);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }

    public OrganizationDto update(OrganizationDto organizationDto){
        log.debug("Request to update Organization : {}", organizationDto);
        Organization organization = organizationRepository.findById(organizationDto.getId()).orElseThrow
                (()-> new IllegalArgumentException("Organization "+ organizationDto.getId() +" not exist"));
        organizationMapper.update(organization,organizationDto);
        organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }


}
