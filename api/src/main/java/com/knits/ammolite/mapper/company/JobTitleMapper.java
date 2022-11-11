package com.knits.ammolite.mapper.company;

import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.company.JobTitle;
import com.knits.ammolite.dto.company.JobTitleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface JobTitleMapper extends EntityMapper<JobTitle, JobTitleDto> {

    @Mapping(target = "createdBy", ignore = true)
    JobTitleDto toDto(JobTitle jobTitle);
}
