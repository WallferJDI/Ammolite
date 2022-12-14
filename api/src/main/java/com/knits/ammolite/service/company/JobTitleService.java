package com.knits.ammolite.service.company;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.company.JobTitle;
import com.knits.ammolite.repository.company.JobTitleRepository;
import com.knits.ammolite.dto.company.JobTitleDto;
import com.knits.ammolite.dto.search.JobTitleSearchDto;
import com.knits.ammolite.mapper.company.JobTitleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository repository;

    @Autowired
    private JobTitleMapper mapper;

    public JobTitleDto createJobTitle(JobTitleDto jobTitleDto) {

        log.debug("Request to save JobTitle : {}", jobTitleDto);

        final JobTitle jobTitle = mapper.toEntity(jobTitleDto);
        repository.save(jobTitle);
        return mapper.toDto(jobTitle);
    }

    public void deleteJobTitle(Long id) {

        log.debug("Delete JobTitle by id : {}", id);
        repository.deleteById(id);
    }

    @Transactional
    public JobTitleDto partialUpdate(JobTitleDto jobTitleDto) {

        log.debug("Request to update BusinessUnit : {}", jobTitleDto);

        JobTitle jobTitle = repository.findById(jobTitleDto.getId()).orElseThrow(()
                -> new UserException("JobTitle#" + jobTitleDto.getId() + " not found"));

        mapper.partialUpdate(jobTitle, jobTitleDto);
        repository.save(jobTitle);
        return mapper.toDto(jobTitle);
    }

    public Page<JobTitleDto> getActive(JobTitleSearchDto jobTitleSearchDto) {

        Page<JobTitle> businessUnitPage = repository.findAllJobTitles(jobTitleSearchDto.getSpecification(), jobTitleSearchDto.getPageable());
        List<JobTitleDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, jobTitleSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public Page<JobTitleDto> getAll(JobTitleSearchDto jobTitleSearchDto) {

        Page<JobTitle> businessUnitPage = repository.findAll(jobTitleSearchDto.getSpecification(), jobTitleSearchDto.getPageable());
        List<JobTitleDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, jobTitleSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }
}
