package com.knits.ammolite.service.common;


import com.knits.ammolite.dto.common.OrganizationDto;
import com.knits.ammolite.dto.search.OrganizationSearchDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.mapper.common.OrganizationMapper;
import com.knits.ammolite.model.common.Organization;
import com.knits.ammolite.repository.common.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrganizationService {


    private final OrganizationMapper organizationMapper;
    private final OrganizationRepository organizationRepository;

    private final CountryService countryService;




    public List<OrganizationDto> getAll(){
        return organizationMapper.toDtos(organizationRepository.findAll());
    }

    public OrganizationDto save(OrganizationDto organizationDto) {
        log.debug("Request to save Organization : {}", organizationDto);
        organizationDto.setTaxRegistrationCountry(
                countryService.save(organizationDto.getTaxRegistrationCountry()));
        organizationDto.getLegalAddressCountry().setCountry(
                countryService.save(organizationDto.getLegalAddressCountry().getCountry()));
        Organization organization = organizationMapper.toEntity(organizationDto);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }

    public OrganizationDto update(OrganizationDto organizationDto) {
        log.debug("Request to update Organization : {}", organizationDto);
        Organization organization = organizationRepository.findById(organizationDto.getId())
                .orElseThrow(() -> new UserException("Organization " + organizationDto.getId() + " not exist"));
        organizationMapper.update(organization, organizationDto);
        organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }

    public OrganizationDto partialUpdate(OrganizationDto organizationDto) {
        log.debug("Request to partially update Organization : {}", organizationDto);
        Organization organization = organizationRepository.findById(organizationDto.getId())
                .orElseThrow(() -> new UserException("Organization " + organizationDto.getId() + " not exist"));
        organizationMapper.partialUpdate(organization, organizationDto);
        organizationRepository.save(organization);
        return organizationMapper.toDto(organization);


    }

    public Page<OrganizationDto> search(OrganizationSearchDto organizationSearchDto) {
        Page<Organization> organizationPage = organizationRepository.findAll(organizationSearchDto.getSpecification(),organizationSearchDto.getPageable());
        List<OrganizationDto> organizationDtos = new ArrayList<>();
        organizationPage.forEach((entity) -> organizationDtos.add(organizationMapper.toDto(entity)));
        return new PageImpl<>(organizationDtos, organizationSearchDto.getPageable(), organizationPage.getTotalElements());
    }

    public void delete(Long id) {
        log.debug("Delete Organization by id : {}", id);
        organizationRepository.deleteById(id);
    }
}

