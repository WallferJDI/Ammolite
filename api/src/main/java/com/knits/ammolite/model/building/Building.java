package com.knits.ammolite.model.building;

import com.knits.ammolite.model.location.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Table(name = "building")
@SQLDelete(sql = "UPDATE building SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Building  implements Serializable {


    private final static long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Cascade(SAVE_UPDATE)
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToOne (fetch = LAZY,cascade = PERSIST)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @OneToOne(fetch = LAZY,cascade = PERSIST)
    @JoinColumn(name = "security_contact_id", nullable = false)
    private SecurityContact security;

    @OneToOne(fetch = LAZY,cascade = PERSIST)
    @JoinColumn(name = "reception_id", nullable = false)
    private Reception reception;

    @Column(name = "deleted")
    private boolean isDeleted=false;









}
