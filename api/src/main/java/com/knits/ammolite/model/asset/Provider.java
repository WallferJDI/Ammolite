package com.knits.ammolite.model.asset;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Provider {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    private String name;
}
