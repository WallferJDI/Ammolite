package com.knits.ammolite.dto.company;

import com.knits.ammolite.dto.RoleDto;
import com.knits.ammolite.dto.common.OrganizationDto;
import com.knits.ammolite.model.company.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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


    private String email;

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

