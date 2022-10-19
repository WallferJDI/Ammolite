package com.knits.ammolite.model.asset;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private LocalDateTime startDate;
    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column
    private String provider;
    @Column
    private Byte[] file;
    @ManyToOne
    private Warranty template;
    @Column
    private Boolean fullCoverage = true;
    @Column
    private Integer maxCoverage;
    @Column
    private String description;

    public void setFullCoverage(Boolean fullCoverage) {
        this.fullCoverage = fullCoverage==null?true:fullCoverage;
    }
}
