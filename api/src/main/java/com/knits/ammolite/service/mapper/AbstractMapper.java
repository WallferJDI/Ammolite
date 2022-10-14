package com.knits.ammolite.service.mapper;

import org.mapstruct.InheritInverseConfiguration;

public interface AbstractMapper<D,E> {

    D toDto(E entity);

    @InheritInverseConfiguration
    E toEntity(D dto);

}
