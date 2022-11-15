package com.knits.ammolite.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@Table(name = "organization")
@SQLDelete(sql = "UPDATE organization SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "tax_registration_country_id")
    private Country taxRegistrationCountry;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address legalAddressCountry;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private ContactPerson contactPerson;

    @Column
    private boolean deleted = Boolean.FALSE;
}
