package com.knits.ammolite.model.partner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vendors")
public class Vendor implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne(cascade = REFRESH, fetch = LAZY)
    @JoinColumn(name = "compnay_id")
    private CompanyData companyName;

    @OneToMany
    private List<BusinessCategory> businessCategories;

    @OneToMany
    private List<Product> products;

    @Min(1)
    @Max(5)
    private int qualityRate;

    @Min(1)
    @Max(5)
    private int deliveryRate;

    private int creditLimit;

    @Enumerated(STRING)
    private DeliveryTerms deliveryTerms;

    @Enumerated(STRING)
    private PaymentTerms paymentTerms;

    @OneToOne
    private FileUploader serviceAgreement;
}
