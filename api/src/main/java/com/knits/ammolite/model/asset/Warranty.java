package com.knits.ammolite.model.asset;

import lombok.Data;

import javax.persistence.*;
import java.io.File;
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

    @OneToOne
    private Provider provider;
    @Column
    private File file;
    @ManyToOne
    private Warranty template;
    @Column
    private boolean fullCoverage = true;
    @Column
    private Integer maxCoverage;
    @Column
    private String description;


}
