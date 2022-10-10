package com.knits.ammolite.service.mapper;
import com.knits.ammolite.model.employee.Employee;
import com.knits.ammolite.service.dto.employee.EmployeeDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface EmployeeMapper {
    @Mapping(source = "employee.gender",target = "gender")
    @Mapping(source = "employee.role",target = "roleDto")
    @Mapping(source = "employee.businessUnit",target = "businessUnitDto")
    @Mapping(source = "employee.organization",target = "organizationDto")
    @Mapping(source = "employee.office",target = "officeDto")
    @Mapping(source = "employee.jobTitle",target = "jobTitleDto")
    @Mapping(source = "employee.department",target = "departmentDto")
    @Mapping(source = "employee.division",target = "divisionDto")
    @Mapping(source = "employee.solidLineManager",target = "solidLineManagerDto")
    EmployeeDto modelEmployeeToEmployeeDto(Employee employee);


    @InheritInverseConfiguration
    Employee employeeDtoToModelEmployee(EmployeeDto employeeDto);

    default void partialUpdate(EmployeeDto employeeDto, @MappingTarget Employee employee){
        if (employeeDto == null) {
            return;
        }
        if (employeeDto.getId() != null) {
            employee.setId(employeeDto.getId());
        }
        if (employeeDto.getFirstName() != null) {
            employee.setFirstName(employeeDto.getFirstName());
        }
        if (employeeDto.getLastName() != null) {
            employee.setLastName(employeeDto.getLastName());
        }
        if (employeeDto.getEmail() != null) {
            employee.setEmail(employeeDto.getEmail());
        }
        if (employeeDto.getDateOfBirth() != null) {
            employee.setDateOfBarth(employeeDto.getDateOfBirth());
        }
        if (employeeDto.getGender() != null) {
            employee.setGender(employee.getGender());
        }

        if (employeeDto.getStartDate() != null) {
            employee.setStartDate(employeeDto.getStartDate());
        }
        if (employeeDto.getCompanyPhone() != null) {
            employee.setCompanyPhone(employeeDto.getCompanyPhone());
        }
        if (employeeDto.getCompanyMobileNumber() != null) {
            employee.setCompanyMobileNumber(employeeDto.getCompanyMobileNumber());
        }
        if (employeeDto.getRoleDto() != null) {
            employee.setRole(employeeDto.getRoleDto());
        }

        if (employeeDto.getBusinessUnitDto() != null) {
            employee.setBusinessUnit(employeeDto.getBusinessUnitDto());
        }
        if (employeeDto.getOrganizationDto() != null) {
            employee.setOrganization(employeeDto.getOrganizationDto());
        }
        if (employeeDto.getOfficeDto() != null) {
            employee.setOffice(employeeDto.getOfficeDto());
        }
        if (employeeDto.getJobTitleDto() != null) {
            employee.setJobTitle(employeeDto.getJobTitleDto());
        }
        if (employeeDto.getDepartmentDto() != null) {
            employee.setDepartment(employeeDto.getDepartmentDto());
        }
        if (employeeDto.getDivisionDto() != null) {
            employee.setDivision(employeeDto.getDivisionDto());
        }
        if (employeeDto.getSolidLineManagerDto() != null) {
            employee.setSolidLineManager(employeeDto.getSolidLineManagerDto());
        }
    }
}
