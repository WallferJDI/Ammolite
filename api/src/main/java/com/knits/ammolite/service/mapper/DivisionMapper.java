package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.model.Division;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.dto.DivisionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface DivisionMapper extends EntityMapper<Division, DivisionDto> {

    @Mapping(target = "createdBy", ignore = true)
    DivisionDto toDto(Division division);
}
