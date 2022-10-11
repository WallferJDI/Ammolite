package com.knits.ammolite.service;

import com.knits.ammolite.model.CostCenter;
import com.knits.ammolite.repository.CostCenterRepository;
import com.knits.ammolite.service.dto.CostCenterDto;
import com.knits.ammolite.service.mapper.CostCenterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
