package com.knits.ammolite.model.procurement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.knits.ammolite.config.Constants;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.JSON_DATE_TIME_PATTERN)
    private LocalDateTime date;
    @Column
    private BigDecimal cost;
    @Column
    private BigDecimal costCenter;
    @Column
    private String invoiceNumber;
}
