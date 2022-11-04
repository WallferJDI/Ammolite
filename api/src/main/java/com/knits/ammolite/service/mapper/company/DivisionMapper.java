package com.knits.ammolite.service.mapper.company;

import com.knits.ammolite.model.company.Division;
import com.knits.ammolite.service.dto.company.DivisionDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface DivisionMapper extends EntityMapper<Division, DivisionDto> {

    @Mapping(target = "createdBy", ignore = true)
    DivisionDto toDto(Division division);
}
