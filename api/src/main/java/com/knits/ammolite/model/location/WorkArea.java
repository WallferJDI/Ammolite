package com.knits.ammolite.model.location;

import com.knits.ammolite.model.enums.LocationUsageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "work_area")
@SQLDelete(sql = "UPDATE work_area SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class WorkArea implements Serializable {

    private final static long serialVersionUID = 8L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "area_name")
    private String name;

    @Column(name = "real_estate")
    @Enumerated(EnumType.STRING)
    private LocationUsageType usage;

    @ManyToOne(cascade = MERGE, fetch = LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @Column(name = "deleted")
    private boolean isDeleted=false;

}
