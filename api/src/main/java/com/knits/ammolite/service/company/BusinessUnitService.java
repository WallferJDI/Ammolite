package com.knits.ammolite.service.company;

import com.knits.ammolite.dto.company.BusinessUnitDto;
import com.knits.ammolite.dto.search.BusinessUnitSearchDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.mapper.company.BusinessUnitMapper;
import com.knits.ammolite.model.company.BusinessUnit;
import com.knits.ammolite.repository.company.BusinessUnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class BusinessUnitService {

    @Autowired
    private BusinessUnitRepository repository;

    @Autowired
    private BusinessUnitMapper mapper;

    @Autowired
    private EntityManager entityManager;

    public BusinessUnitDto createBusinessUnit(BusinessUnitDto businessUnitDto) {
        log.debug("Request to save BusinessUnit : {}", businessUnitDto);

        final BusinessUnit businessUnit = mapper.toEntity(businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    @Transactional
    public BusinessUnitDto updateBusinessUnit(BusinessUnitDto businessUnitDto) {
        log.debug("Request to update BusinessUnit : {}", businessUnitDto);

        BusinessUnit businessUnit = repository.findById(businessUnitDto.getId()).orElseThrow(()
                -> new UserException("BusinessUnit#" + businessUnitDto.getId() + " not found"));
        mapper.update(businessUnit, businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    @Transactional
    public BusinessUnitDto partialUpdate(BusinessUnitDto businessUnitDto) {
        log.debug("Request to update BusinessUnit : {}", businessUnitDto);

        BusinessUnit businessUnit = repository.findById(businessUnitDto.getId()).orElseThrow(()
                -> new UserException("BusinessUnit#" + businessUnitDto.getId() + " not found"));

        mapper.partialUpdate(businessUnit, businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    public void deleteBusinessUnit(Long id) {
        log.debug("Delete BusinessUnit by id : {}", id);
        repository.deleteById(id);
    }

    public Page<BusinessUnitDto> getActive(BusinessUnitSearchDto businessUnitSearchDto) {

        Page<BusinessUnit> businessUnitPage = repository.findAllBusinessUnit(businessUnitSearchDto.getSpecification(), businessUnitSearchDto.getPageable());
        List<BusinessUnitDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, businessUnitSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public Page<BusinessUnitDto> getAll(BusinessUnitSearchDto businessUnitSearchDto) {

        Page<BusinessUnit> businessUnitPage = repository.findAll(businessUnitSearchDto.getSpecification(), businessUnitSearchDto.getPageable());
        List<BusinessUnitDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, businessUnitSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public List<BusinessUnitDto> find(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedUserFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<BusinessUnitDto> businessUnitDtos = mapper.toDtos(repository.findAll());
        session.disableFilter("isDeleted");
        return businessUnitDtos;
    }
}
