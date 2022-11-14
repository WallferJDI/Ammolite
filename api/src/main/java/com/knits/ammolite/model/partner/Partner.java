package com.knits.ammolite.model.partner;

import com.knits.ammolite.model.common.Address;
import com.knits.ammolite.model.common.ContactPerson;
import com.knits.ammolite.model.common.Organization;
import com.knits.ammolite.model.company.Status;
import com.knits.ammolite.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Partner implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "data_id")
    private Organization legalData;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "contact_id")
    private ContactPerson contact;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "web_url")
    private String webUrl;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "start_date")
    @CreationTimestamp
    private ZonedDateTime startDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Enumerated(STRING)
    @Column(columnDefinition = "ACTIVE", insertable = false)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
}
