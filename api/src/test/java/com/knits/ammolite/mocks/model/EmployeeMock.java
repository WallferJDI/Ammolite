package com.knits.ammolite.mocks.model;

import com.knits.ammolite.model.company.Employee;
import com.knits.ammolite.model.company.Gender;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMock {

        public static Employee shallowEmployeeMock(Long id) {
            return Employee.builder()
                    .id(id)
                    .firstName("John"+id)
                    .lastName("Doe"+id)
                    .email("john.doe@kehne+nagel.com")
                    .dateOfBirth("10/10/2000")
                    .gender(Gender.MALE)
                    .startDate("10/11/2022")
                    .companyPhone("123456789")
                    .companyMobileNumber("123456789")
                   // .role(new Role(id, RoleDtoMock.shallowRoleDto(id).getName()))
                    //.businessUnit(BusinessUnitMock.shallowBusinessUnit(id))
                  //  .organization(OrganizationMock.shallowOrganization(id))
                  //  .office(new Office(id, OfficeDtoMock.shallowOfficeDto(id).getName()))
                   // .jobTitle(JobTitleMock.shallowJobTitle(id))
                    //.department(DepartmentMock.shallowDepartmentDto(id))
                  //  .division(DivisionMock.shallowDivision(id))
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
