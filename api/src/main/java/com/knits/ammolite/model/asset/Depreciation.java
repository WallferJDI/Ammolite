package com.knits.ammolite.model.asset;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.knits.ammolite.config.Constants;
import com.knits.ammolite.model.enums.DepreciationMethodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Depreciation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.JSON_DATE_PATTERN)
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
    private BigDecimal salvation;


}
