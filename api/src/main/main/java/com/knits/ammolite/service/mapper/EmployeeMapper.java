package com.knits.ammolite.service.mapper;
import com.knits.ammolite.model.Employee;
import com.knits.ammolite.repository.EmployeeRepository;
import com.knits.ammolite.service.dto.EmployeeDto;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper employeeMapper = null;

    EmployeeRepository employeeRepository = null;


    Employee dtoToEntity(EmployeeDto employeeDto);

    @InheritInverseConfiguration
    EmployeeDto entityToDto(Employee employee);

    @Named("partial update")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget EmployeeDto employeeDto, Employee employee);
}
