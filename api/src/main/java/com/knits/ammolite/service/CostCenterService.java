package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.CostCenter;
import com.knits.ammolite.repository.CostCenterRepository;
import com.knits.ammolite.service.dto.CostCenterDto;
import com.knits.ammolite.service.dto.search.CostCenterSearchDto;
import com.knits.ammolite.service.mapper.CostCenterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class CostCenterService {

    @Autowired
    private CostCenterRepository repository;

    @Autowired
    CostCenterMapper mapper;

    public CostCenterDto createBusinessUnit(CostCenterDto costCenterDto) {
        log.debug("Request to save CostCenter : {}", costCenterDto);

        final CostCenter costCenter = mapper.toEntity(costCenterDto);
        repository.save(costCenter);
        return mapper.toDto(costCenter);
    }

    public void deleteCostCenter(Long id) {
        log.debug("Delete CostCenter by id : {}", id);
        repository.deleteById(id);
    }

    @Transactional
    public CostCenterDto partialUpdate(CostCenterDto costCenterDto) {
        log.debug("Request to update CostCenter : {}", costCenterDto);

        CostCenter costCenter = repository.findById(costCenterDto.getId()).orElseThrow(()
                -> new UserException("CostCenter#" + costCenterDto.getId() + " not found"));

        mapper.partialUpdate(costCenter, costCenterDto);
        repository.save(costCenter);
        return mapper.toDto(costCenter);
    }

    public Page<CostCenterDto> getAll(CostCenterSearchDto costCenterSearchDto) {

        Page<CostCenter> costCenterPage = repository.findAll(costCenterSearchDto.getSpecification(), costCenterSearchDto.getPageable());
        List<CostCenterDto> costCenterDtos = mapper.toDtos(costCenterPage.getContent());
        return new PageImpl<>(costCenterDtos, costCenterSearchDto.getPageable(), costCenterPage.getTotalElements());
    }

    public Page<CostCenterDto> getActive(CostCenterSearchDto costCenterSearchDto) {

        Page<CostCenter> costCenterPage = repository.findAllCostCenters(costCenterSearchDto.getSpecification(), costCenterSearchDto.getPageable());
        List<CostCenterDto> costCenterDtos = mapper.toDtos(costCenterPage.getContent());
        return new PageImpl<>(costCenterDtos, costCenterSearchDto.getPageable(), costCenterPage.getTotalElements());
    }
}
