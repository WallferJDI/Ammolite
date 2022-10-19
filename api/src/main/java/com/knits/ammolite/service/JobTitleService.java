package com.knits.ammolite.service;

import com.knits.ammolite.model.JobTitle;
import com.knits.ammolite.repository.JobTitleRepository;
import com.knits.ammolite.service.dto.search.JobTitleDto;
import com.knits.ammolite.service.mapper.JobTitleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
