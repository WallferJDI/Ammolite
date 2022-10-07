package com.knits.ammolite.service.dto.employee;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email = firstName + "." + lastName + "@kuehne-nagel.com";
    private Date dateOfBirth;
    private GenderDto genderDto;
    private Date startDate;
    private String companyPhone;
    private String companyMobileNumber;
    private RoleDto roleDto;
    private BusinessUnitDto businessUnitDto;
    private OrganizationDto organizationDto;
    private OfficeDto officeDto;
    private JobTitleDto jobTitleDto;
    private DepartmentDto departmentDto;
    private DivisionDto divisionDto;
    private SolidLineManagerDto solidLineManagerDto;
}
