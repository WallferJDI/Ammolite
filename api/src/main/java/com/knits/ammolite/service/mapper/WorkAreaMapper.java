package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.location.WorkArea;
import com.knits.ammolite.service.dto.WorkAreaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkAreaMapper extends EntityMapper<WorkArea, WorkAreaDto> {
}
