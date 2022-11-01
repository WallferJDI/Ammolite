package com.knits.ammolite.model.employee;

import lombok.*;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String dateOfBirth;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    private Gender gender;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "company_phone", nullable = false)
    private String companyPhone;

    @Column(name = "company_mobile_number", nullable = false)
    private String companyMobileNumber;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    private Role role;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "business_unit", referencedColumnName = "business_unit_id")
    private BusinessUnit businessUnit;



    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "organization", referencedColumnName = "organization_id")
    private Organization organization;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "office", referencedColumnName = "office_id")
    private Office office;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "job_title", referencedColumnName = "job_title_id")
    private JobTitle jobTitle;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "department", referencedColumnName = "department_id")
    private Department department;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "division", referencedColumnName = "division_id")
    private Division division;

//    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            optional = false
//    )
//    @JoinColumn(name = "")
    @Column(name = "solid_line_manager", nullable = false)
    private Employee solidLineManager;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

}


