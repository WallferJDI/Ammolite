package com.knits.ammolite.model.asset;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.knits.ammolite.config.Constants;
import com.knits.ammolite.model.template.WarrantyTemplate;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.JSON_DATE_PATTERN)
    private LocalDateTime startDate;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.JSON_DATE_PATTERN)
    private LocalDateTime endDate;
    @Column
    private BigDecimal cost;
    @Column
    private String provider;
    @Column
    private Byte[] file;
    @ManyToOne(fetch = FetchType.LAZY)
    private WarrantyTemplate template;
    @Column
    private Boolean fullCoverage = true;
    @Column
    private BigDecimal maxCoverage;
    @Column
    private String description;

    public void setFullCoverage(Boolean fullCoverage) {
        this.fullCoverage = fullCoverage==null?true:fullCoverage;
    }

    public void setTemplate(WarrantyTemplate template) {
        this.template = template;
        setFullCoverage(template.getFullCoverage());
        setMaxCoverage(template.getMaxCoverage());
        setDescription(template.getDescription());
    }

    public void setMaxCoverage(BigDecimal maxCoverage) {
        this.maxCoverage = getFullCoverage()==true?getCost():maxCoverage;
    }
}
