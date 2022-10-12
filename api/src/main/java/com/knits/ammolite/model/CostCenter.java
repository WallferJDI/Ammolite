package com.knits.ammolite.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cost_center")
@SQLDelete(sql = "UPDATE cost_center SET status = 'INACTIVE' WHERE id=?")
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "INACTIVE", type = "string"))
@Filter(name = "deletedFilter", condition = "status = :'INACTIVE'")
public class CostCenter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @CreationTimestamp
    private ZonedDateTime startDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Enumerated(STRING)
    @ColumnDefault("ACTIVE")
    private Status status = Status.valueOf("ACTIVE");

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
}
