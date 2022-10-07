package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.employee.Employee;
import com.knits.ammolite.service.dto.employee.EmployeeDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto modelEmployeeToEmployeeDto(Employee employee);
    Employee employeeDtoToModelEmployee(EmployeeDto employeeDto);
}
