package com.knits.ammolite.model.asset;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String name;
}
