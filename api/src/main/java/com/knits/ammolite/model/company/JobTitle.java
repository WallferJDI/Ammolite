package com.knits.ammolite.model.company;

import com.knits.ammolite.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "job_titles")
@SQLDelete(sql = "UPDATE job_titles SET status = 'INACTIVE' WHERE id=?")
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "INACTIVE", type = "string"))
@Filter(name = "deletedFilter", condition = "status = :'INACTIVE'")
public class JobTitle implements Serializable {

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
    @Column(columnDefinition = "ACTIVE", insertable = false)
    @Builder.Default
    private Status status = Status.valueOf("ACTIVE");

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

}
