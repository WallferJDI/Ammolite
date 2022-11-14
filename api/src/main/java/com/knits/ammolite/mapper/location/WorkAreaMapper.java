package com.knits.ammolite.mapper.location;

import com.knits.ammolite.dto.location.WorkAreaDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.location.WorkArea;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {FloorMapper.class},unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkAreaMapper extends EntityMapper<WorkArea, WorkAreaDto> {

}
