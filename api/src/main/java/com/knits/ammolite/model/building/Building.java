package com.knits.ammolite.model.building;

import com.knits.ammolite.model.location.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Table(name = "building")
public class Building  implements Serializable {


    private final static long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToOne (fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "security_contact_id", nullable = false)
    private SecurityContact security;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "reception_id", nullable = false)
    private Reception reception;

    @Column(name = "deleted")
    private boolean isDeleted=false;









}
