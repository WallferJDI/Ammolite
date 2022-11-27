package com.knits.ammolite.model.asset;

import com.knits.ammolite.model.company.Status;
import com.knits.ammolite.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.EnumType.STRING;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;


    @Column(nullable = false,unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;


    @Column(name = "start_date")
    @CreationTimestamp
    private ZonedDateTime startDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Enumerated(STRING)
    @Column(columnDefinition = "ACTIVE", insertable = false)
    private Status status;

    @ManyToOne(cascade = REFRESH, fetch = FetchType.LAZY)
    private User createdBy;

}
