package com.knits.ammolite.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(unique = true,nullable = false)
    private String organizationName;

    @Column
    private String organizationAlias;

    @Column(nullable = false)
    private String VAT;

    @Column(nullable = false)
    private String registrationCode;

    @Column(nullable = false)
    private String taxRegistrationCountry;

    @Column(nullable = false)
    private String legalAddressCountry;

    @Column(nullable = false)
    private String legalAddressCity;

    @Column(nullable = false)
    private String legalAddressStreet;

    @Column(nullable = false)
    private String legalAddressZipcode;

    @OneToOne
    @JoinColumn(name = "id")
    private ContactPerson contactPerson;
}
