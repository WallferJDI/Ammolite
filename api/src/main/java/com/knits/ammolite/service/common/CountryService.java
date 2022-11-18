
package com.knits.ammolite.service.common;

import com.knits.ammolite.dto.common.CountryDto;
import com.knits.ammolite.mapper.common.CountryMapper;
import com.knits.ammolite.model.common.Country;
import com.knits.ammolite.repository.common.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CountryService {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryDto save(CountryDto countryDto){
        log.debug("Request to save Country : {}", countryDto);
        Country country;
        if (repository.existsByName(countryDto.getName())){
           country = repository.findByName(countryDto.getName()).get();
        }else{
            country = repository.save(mapper.toEntity(countryDto));
        }
        return mapper.toDto(country);
    }
}

