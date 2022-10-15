package com.knits.ammolite.model.asset;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(unique = true,nullable = false)
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
