package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.model.JobTitle;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.dto.JobTitleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface JobTitleMapper extends EntityMapper<JobTitle, JobTitleDto> {

    @Mapping(target = "createdBy", ignore = true)
    JobTitleDto toDto(JobTitle jobTitle);
}
