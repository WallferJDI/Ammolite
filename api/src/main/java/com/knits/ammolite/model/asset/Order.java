package com.knits.ammolite.model.asset;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "[order]")
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
    private BigDecimal cost;
    @Column
    private BigDecimal costCenter;
    @Column
    private String invoiceNumber;
}
