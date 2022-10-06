package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.model.Status;
import com.knits.ammolite.repository.BusinessUnitRepository;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.mapper.BusinessUnitMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessUnitService {

    @Autowired
    private BusinessUnitRepository repository;

    @Autowired
    private BusinessUnitMapper mapper;

    public BusinessUnitDto createBusinessUnit(BusinessUnitDto businessUnitDto) {
        log.debug("Request to save User : {}", businessUnitDto);

        final BusinessUnit businessUnit = mapper.toEntity(businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    public BusinessUnitDto updateBusinessUnit(BusinessUnitDto businessUnitDto) {
        log.debug("Request to update BusinessUnit : {}", businessUnitDto);

        BusinessUnit businessUnit = repository.findById(businessUnitDto.getId()).orElseThrow(()
                -> new UserException("BusinessUnit#" + businessUnitDto.getId() + " not found"));
        mapper.update(businessUnitDto, businessUnit);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    public void deleteBusinessUnit(Long id){
        log.debug("Delete BusinessUnit by id : {}", id);
        BusinessUnit businessUnit = repository.findById(id).orElseThrow(()
                -> new UserException("BusinessUnit#" + id + " not found"));
        businessUnit.setStatus(Status.INACTIVE);
        repository.save(businessUnit);
    }
}
