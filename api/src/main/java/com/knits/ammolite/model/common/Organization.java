package com.knits.ammolite.model.common;

import com.knits.ammolite.model.partner.ContactPerson;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "organization")
@SQLDelete(sql = "UPDATE organization SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String alias;

    @Column(nullable = false)
    private String vatNumber;

    @Column(nullable = false)
    private String registrationCode;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id")
    private Country taxRegistrationCountry;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id")
    private Country legalAddressCountry;

    @Column(nullable = false)
    private String legalAddressCity;

    @Column(nullable = false)
    private String legalAddressStreet;

    @Column(nullable = false)
    private String legalAddressZipcode;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id")
    private ContactPerson contactPerson;

    @Column
    private boolean deleted = Boolean.FALSE;
}
