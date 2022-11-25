package com.knits.ammolite.model.template;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Table(name = "warranty_template")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyTemplate  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private Boolean fullCoverage = true;
    @Column
    private BigDecimal maxCoverage;
    @Column
    private String description;
}
