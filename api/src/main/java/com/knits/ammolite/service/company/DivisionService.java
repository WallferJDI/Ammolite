package com.knits.ammolite.service.company;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.company.Division;
import com.knits.ammolite.repository.company.DivisionRepository;
import com.knits.ammolite.service.dto.company.DivisionDto;
import com.knits.ammolite.service.dto.search.DivisionSearchDto;
import com.knits.ammolite.service.mapper.company.DivisionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public Page<DivisionDto> getActive(DivisionSearchDto divisionSearchDto) {

        Page<Division> businessUnitPage = repository.findAllDivisions(divisionSearchDto.getSpecification(), divisionSearchDto.getPageable());
        List<DivisionDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, divisionSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public Page<DivisionDto> getAll(DivisionSearchDto divisionSearchDto) {

        Page<Division> businessUnitPage = repository.findAll(divisionSearchDto.getSpecification(), divisionSearchDto.getPageable());
        List<DivisionDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, divisionSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }
}
