package com.knits.ammolite.model.employee;

import com.knits.ammolite.service.dto.employee.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "role_id")
    private Long id;
    private String name;
}
