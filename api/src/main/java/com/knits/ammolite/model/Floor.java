package com.knits.ammolite.model;

import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.location.RealEstateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "floor")
@SQLDelete(sql = "UPDATE floor SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Floor {

    private final static long serialVersionUID = 7L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "floor_number")
    private String floorNumber;

    @Column(name = "real_estate")
    @Enumerated(EnumType.STRING)
    private RealEstateType realEstate;

    @ManyToOne(cascade = MERGE, fetch = LAZY)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @Column(name = "deleted")
    private boolean isDeleted=false;
}
