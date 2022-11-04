package com.knits.ammolite.model.partner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "companys_data")
public class CompanyData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "aka")
    private String alias;

    @Column(name = "vat_number", nullable = false)
    private String vatNumber;

    @Column(name = "reg_code", nullable = false)
    private String registrationCode;

    @ManyToOne(cascade = PERSIST , fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country taxRegistrationCountry;
}
