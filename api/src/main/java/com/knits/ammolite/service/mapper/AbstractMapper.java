package com.knits.ammolite.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

public interface AbstractMapper<D,E> {

    D toDto(E entity);

    @InheritInverseConfiguration
    E toEntity(D dto);

}
