package com.knits.ammolite.model;


import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "location")
@SQLDelete(sql = "UPDATE location SET deleted = true WHERE id=?")
@FilterDef(name = "deletedLocationFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedLocationFilter", condition = "deleted = :isDeleted")
public class Location implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NonNull
    private String title;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "country", nullable = false)
    private Country country;

    @NonNull
    private String address;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private Ownership ownership;

    @Column(name = "map_coordinates")
    private boolean mapCoordinates = false;

    private String latitude;
    private String longitude;

    @Column(name = "real_estate")
    @Enumerated(EnumType.STRING)
    private RealEstate realEstate;

    private boolean deleted = false;




}
