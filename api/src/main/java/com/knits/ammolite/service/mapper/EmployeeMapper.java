package com.knits.ammolite.service.mapper;
import com.knits.ammolite.model.employee.Employee;
import com.knits.ammolite.service.dto.employee.EmployeeDto;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee dtoToEntity(EmployeeDto employeeDto);

    @InheritInverseConfiguration
    EmployeeDto entityToDto(Employee employee);

    @Named("update")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget EmployeeDto employeeDto, Employee employee);
}
