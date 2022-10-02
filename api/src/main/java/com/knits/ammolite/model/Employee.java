package com.knits.ammolite.model.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", length = 254, unique = true)
    private String email = firstName + "." + lastName + "@kuehne-nagel.com";

    @Column(name = "dob")
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "company_phone")
    private String companyPhone;

    @Column(name = "company_mobile_number")
    private String companyMobileNumber;

    @Column(name = "role")
    private String role = String.valueOf(Role.class);

    @Column(name = "business_unit")
    private String businessUnit = String.valueOf(BusinessUnit.class);

    @Column(name = "organization")
    private String organization = String.valueOf(Organization.class);

    @Column(name = "office")
    private String office = String.valueOf(Office.class);

    @Column(name = "job_title")
    private String jobTitle = String.valueOf(JobTitle.class);

    @Column(name = "department")
    private String department = String.valueOf(Department.class);

    @Column(name = "division")
    private String division = String.valueOf(Division.class);

    @Column(name = "solid_line_manager")
    private String solidLineManager = String.valueOf(SolidLineManager.class);

    public class Division {
        private Long id;
        private String divisionName;
    }

    public class SolidLineManager {
        private Long id;
        private String solidLineName;
    }

    public class Role {
        private Long id;
        private String roleName;
    }

    public class Organization {
        private Long id;
        private String organizationName;
    }

     public class Office {
        private Long id;
        private String officeName;
    }

    public class JobTitle {
        private Long id;
        private String jobTitlename;
    }

    public enum Gender {
        Male,
        Female;
    }

    public class Department {
        private Long id;
        private String departmentName;
    }

    public class BusinessUnit {
        private Long id;
        private String businessUnitName;
    }
}


