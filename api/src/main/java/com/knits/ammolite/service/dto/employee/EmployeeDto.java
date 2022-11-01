package com.knits.ammolite.service.dto.employee;

import com.knits.ammolite.model.employee.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;
    @NotNull()
    private String firstName;
    @NotNull()
    private String lastName;

    private String email = firstName + "." + lastName + "@kuehne-nagel.com";

    @NotNull()
    private String dateOfBirth;

    @NotNull()
    private Gender gender;

    @NotNull()
    private String startDate;

    @NotNull()
    private String companyPhone;

    @NotNull()
    private String companyMobileNumber;

    @NotNull()
    private RoleDto role;

    @NotNull()
    private BusinessUnitDto businessUnit;

    @NotNull()
    private OrganizationDto organization;

    @NotNull()
    private OfficeDto office;

    @NotNull()
    private JobTitleDto jobTitle;

    @NotNull()
    private DepartmentDto department;

    @NotNull()
    private DivisionDto division;

    @NotNull()
    private EmployeeDto solidLineManager;
}

