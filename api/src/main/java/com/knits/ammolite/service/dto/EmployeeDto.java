package com.knits.ammolite.service.dto;

import com.knits.ammolite.model.employee.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email = firstName + "." + lastName + "@kuehne-nagel.com";
    private Date dob;
    private Employee.Gender gender;
    private Date startDate;
    private String companyPhone;
    private String companyMobileNumber;
    private String role;
    private String businessUnit;
    private String organization;
    private String office;
    private String jobTitle;
    private String department;
    private String division;
    private String solidLineManager;
}
