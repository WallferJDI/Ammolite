package com.knits.ammolite.service.dto.employee;

import com.knits.ammolite.model.employee.*;
import lombok.*;

import java.util.Date;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email = firstName + "." + lastName + "@kuehne-nagel.com";
    private Date dateOfBirth;
    private Gender gender;
    private Date startDate;
    private String companyPhone;
    private String companyMobileNumber;
    private Role roleDto;
    private BusinessUnit businessUnitDto;
    private Organization organizationDto;
    private Office officeDto;
    private JobTitle jobTitleDto;
    private Department departmentDto;
    private Division divisionDto;
    private SolidLineManager solidLineManagerDto;
}
