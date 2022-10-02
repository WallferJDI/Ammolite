package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.employee.Employee;
import com.knits.ammolite.service.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto modelEmployeeToEmployeeDto(Employee employee);
    Employee employeeDtoToModelEmployee(EmployeeDto employeeDto);
}
