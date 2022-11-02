package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.company.JobTitle;
import com.knits.ammolite.service.dto.search.JobTitleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface JobTitleMapper extends EntityMapper<JobTitle, JobTitleDto> {
}
