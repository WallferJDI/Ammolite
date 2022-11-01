package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.model.Gender;
import com.knits.ammolite.service.dto.*;


public class EmployeeDtoMock {

    public static EmployeeDto shallowEmployeeDto(Long id) {
        return EmployeeDto.builder()
                .id(id)
                .firstName("Employee 1")
                .lastName("Employee 1")
                .email("employye@gmail.com")
                .dateOfBirth("10/10/2000")
                .gender(Gender.MALE)
                .startDate("10/11/2022")
                .companyPhone("123456789")
                .companyMobileNumber("123456789")
                .role(new RoleDto(id, RoleDtoMock.shallowRoleDto(id).getName()))
                .businessUnit(new BusinessUnitDto(id, BusinessUnitDtoMock.shallowBusinessUnitDto(id).getName()))
                .organization(new OrganizationDto(id, OrganizationDtoMock.shallowOrganizationDto(id).getName()))
                .office(new OfficeDto(id, OfficeDtoMock.shallowOfficeDto(id).getName()))
                .jobTitle(new JobTitleDto(id, JobTitleDtoMock.shallowJobTitleDto(id).getName()))
                .department(new DepartmentDto(id, DepartmentDtoMock.shallowDepartmentDto(id).getName()))
                .division(new DivisionDto(id, DivisionDtoMock.shallowDivisionDto(id).getName()))
                .build();
    }
}
