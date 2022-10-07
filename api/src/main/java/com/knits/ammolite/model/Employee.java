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

    @Column(name = "date_of_birth")
    private Date dateOfBarth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "company_phone")
    private String companyPhone;

    @Column(name = "company_mobile_number")
    private String companyMobileNumber;

    @Column(name = "role")
    private Role role;

    @Column(name = "business_unit")
    private BusinessUnit businessUnit;

    @Column(name = "organization")
    private Organizaion organizaion;

    @Column(name = "office")
    private Office office;

    @Column(name = "job_title")
    private JobTitle jobTitle;

    @Column(name = "department")
    private Department department;

    @Column(name = "division")
    private Division division;

    @Column(name = "solid_line_manager")
    private SolidLineManager solidLineManager;
}


