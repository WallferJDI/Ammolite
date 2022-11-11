package com.knits.ammolite.mapper.company;

import com.knits.ammolite.dto.company.DepartmentDto;
import com.knits.ammolite.dto.company.DivisionDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.company.Department;
import com.knits.ammolite.model.company.Division;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface DepartmentMapper extends EntityMapper<Department, DepartmentDto> {

}
