package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.model.Division;
import com.knits.ammolite.repository.DivisionRepository;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.dto.DivisionDto;
import com.knits.ammolite.service.mapper.DivisionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class DivisionService {

    @Autowired
    private DivisionRepository repository;

    @Autowired
    private DivisionMapper mapper;

    public DivisionDto createDivision(DivisionDto divisionDto) {
        log.debug("Request to save Division : {}", divisionDto);

        final Division businessUnit = mapper.toEntity(divisionDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    public void deleteDivision(Long id) {
        log.debug("Delete Division by id : {}", id);
        repository.deleteById(id);
    }

    @Transactional
    public DivisionDto partialUpdate(DivisionDto divisionDto) {
        log.debug("Request to update Division : {}", divisionDto);

        Division division = repository.findById(divisionDto.getId()).orElseThrow(()
                -> new UserException("Division#" + divisionDto.getId() + " not found"));

        mapper.partialUpdate(division, divisionDto);
        repository.save(division);
        return mapper.toDto(division);
    }
}
