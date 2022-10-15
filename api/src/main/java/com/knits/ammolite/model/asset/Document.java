package com.knits.ammolite.model.asset;

import com.knits.ammolite.model.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column
    private String name;
    @Column
    private DocumentType type;
    @Column
    private URL link;
}
