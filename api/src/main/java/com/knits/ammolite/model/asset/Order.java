package com.knits.ammolite.model.asset;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(unique = true)
    private String code;
    @Column
    private LocalDateTime date;
    @Column
    private Integer cost;
    @Column
    private String costCenter;
    @Column
    private String invoiceNumber;
}
