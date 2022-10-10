package com.knits.ammolite.model.employee;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@FilterDef(name = "deletedEmployeeFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedEmployeeFilter", condition = "deleted = :isDeleted")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 254, unique = true, nullable = false)
    private String email = firstName + "." + lastName + "@kuehne-nagel.com";

    @Column(name = "date_of_birth", nullable = false)
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
    @Embedded
    private Role role;

    @Column(name = "business_unit")
    @Embedded
    private BusinessUnit businessUnit;

    @Column(name = "organization")
    @Embedded
    private Organization organization;

    @Column(name = "office")
    @Embedded
    private Office office;

    @Column(name = "job_title")
    @Embedded
    private JobTitle jobTitle;

    @Column(name = "department")
    @Embedded
    private Department department;

    @Column(name = "division")
    @Embedded
    private Division division;

    @Column(name = "solid_line_manager")
    @Embedded
    private SolidLineManager solidLineManager;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;
}


