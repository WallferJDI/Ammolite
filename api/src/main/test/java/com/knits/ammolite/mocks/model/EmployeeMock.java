package com.knits.ammolite.mocks.model;

import com.knits.ammolite.mocks.dto.*;
import com.knits.ammolite.model.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMock {

        public static Employee shallowEmployeeMock(Long id) {
            return Employee.builder()
                    .id(id)
                    .firstName("Employee first name")
                    .lastName("Employee last name")
                    .email("feijefij")
                    .dateOfBirth("10/10/2000")
                    .gender(Gender.MALE)
                    .startDate("10/11/2022")
                    .companyPhone("123456789")
                    .companyMobileNumber("123456789")
                    .role(new Role(id, RoleDtoMock.shallowRoleDto(id).getName()))
                    .businessUnit(new BusinessUnit(id, BusinessUnitDtoMock.shallowBusinessUnitDto(id).getName()))
                    .organization(new Organization(id, OrganizationDtoMock.shallowOrganizationDto(id).getName()))
                    .office(new Office(id, OfficeDtoMock.shallowOfficeDto(id).getName()))
                    .jobTitle(new JobTitle(id, JobTitleDtoMock.shallowJobTitleDto(id).getName()))
                    .department(new Department(id, DepartmentDtoMock.shallowDepartmentDto(id).getName()))
                    .division(new Division(id, DivisionDtoMock.shallowDivisionDto(id).getName()))
                    .build();
        }

        public static List<Employee> shallowEmployeeMockList() {
           List<Employee> mockEmployees = new ArrayList<>();
           for (int i = 0; i < 10; i++) {
               mockEmployees.add(shallowEmployeeMock((long) i));
           }
              return mockEmployees;
        }
}
