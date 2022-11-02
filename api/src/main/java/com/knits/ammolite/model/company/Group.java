package com.knits.ammolite.model.company;


import com.knits.ammolite.model.User;
import com.knits.ammolite.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;



@Entity
@Table(name = "[group]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    @CreationTimestamp
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private User creator;

    public void setStatus(Status status) {
        this.status = status==null ? Status.Active : status;
    }
}
