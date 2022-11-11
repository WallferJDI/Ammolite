package com.knits.ammolite.mapper.company;

import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.company.Division;
import com.knits.ammolite.dto.company.DivisionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface DivisionMapper extends EntityMapper<Division, DivisionDto> {

    @Mapping(target = "createdBy", ignore = true)
    DivisionDto toDto(Division division);
}
