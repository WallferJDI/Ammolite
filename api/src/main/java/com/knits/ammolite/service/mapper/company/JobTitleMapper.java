package com.knits.ammolite.service.mapper.company;

import com.knits.ammolite.model.company.JobTitle;
import com.knits.ammolite.service.dto.company.JobTitleDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface JobTitleMapper extends EntityMapper<JobTitle, JobTitleDto> {

    @Mapping(target = "createdBy", ignore = true)
    JobTitleDto toDto(JobTitle jobTitle);
}
