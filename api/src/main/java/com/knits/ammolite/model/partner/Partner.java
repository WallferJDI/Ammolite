package com.knits.ammolite.model.partner;

import com.knits.ammolite.model.common.Address;
import com.knits.ammolite.model.common.User;
import com.knits.ammolite.model.company.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "partners")
public class Partner implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    @JoinColumn(name = "data_id")
    private CompanyData legalData;

    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "contact_id")
    private ContactPerson contact;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "web_id")
    private Web web;

    @Column(name = "start_date")
    @CreationTimestamp
    private ZonedDateTime startDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Enumerated(STRING)
    @Column(columnDefinition = "ACTIVE", insertable = false)
    private Status status;

    @ManyToOne(cascade = REFRESH, fetch = LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
}
