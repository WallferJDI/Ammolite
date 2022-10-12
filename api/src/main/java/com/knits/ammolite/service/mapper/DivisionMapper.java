package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Division;
import com.knits.ammolite.service.dto.DivisionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface DivisionMapper extends EntityMapper<Division, DivisionDto> {
}
