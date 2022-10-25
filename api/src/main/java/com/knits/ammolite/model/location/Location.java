package com.knits.ammolite.model.location;


import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "location")
public class Location implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NonNull
    private String title;

    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @NonNull
    private String address;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("OUR_PREMISES")
    private OwnershipType ownership = OwnershipType.valueOf("OUR_PREMISES");

    @Column(name = "map_coordinates")
    private boolean mapCoordinates;

    private String latitude;
    private String longitude;

    @Column(name = "real_estate")
    @Enumerated(EnumType.STRING)
    private RealEstateType realEstate;

    @Column(name = "deleted")
    private boolean isDeleted=false;




}
