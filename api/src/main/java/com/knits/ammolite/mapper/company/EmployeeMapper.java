package com.knits.ammolite.mapper.company;

import com.knits.ammolite.dto.company.EmployeeDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.common.OrganizationMapper;
import com.knits.ammolite.mapper.location.LocationMapper;
import com.knits.ammolite.mapper.security.RolerMapper;
import com.knits.ammolite.model.company.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {OrganizationMapper.class, DivisionMapper.class, BusinessUnitMapper.class,
                CostCenterMapper.class, GroupMapper.class, JobTitleMapper.class, TeamMapper.class,
                DepartmentMapper.class, LocationMapper.class, RolerMapper.class})
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDto> {

}
