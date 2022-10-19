package com.knits.ammolite.model.asset;

import com.knits.ammolite.model.enums.DepreciationMethodType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Entity
@Data
public class Depreciation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startDate;
    @Column
    private BigDecimal depreciableCost;
    @Column
    private BigDecimal currentValue;
    @Column
    private Month lifespan;
    @Column
    private DepreciationMethodType depreciationMethod;
    @Column
    private Integer salvation;


}
