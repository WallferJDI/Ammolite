package com.knits.ammolite.service;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.JobTitle;
import com.knits.ammolite.model.Status;
import com.knits.ammolite.repository.JobTitleRepository;
import com.knits.ammolite.service.dto.JobTitleDto;
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

    public void deleteJobTitle(Long id) {

        log.debug("Delete JobTitle by id : {}", id);

        JobTitle jobTitle = repository.findById(id).orElseThrow(()
                -> new UserException("JobTitle#" + id + " not found"));
        jobTitle.setStatus(Status.INACTIVE);
        repository.save(jobTitle);
    }
}
