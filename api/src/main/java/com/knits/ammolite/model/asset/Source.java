package com.knits.ammolite.model.asset;

import com.knits.ammolite.model.enums.Ownership;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private Ownership ownership;
    @OneToOne
    @JoinColumn(name = "id")
    private Vendor vendor;
    @OneToOne
    @JoinColumn(name = "id")
    private Order order;
}
