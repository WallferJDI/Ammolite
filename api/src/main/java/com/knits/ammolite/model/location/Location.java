package com.knits.ammolite.model.location;

import com.knits.ammolite.model.common.Country;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "location")
@SQLDelete(sql = "UPDATE location SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Location implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
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
