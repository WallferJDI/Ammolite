package com.knits.ammolite.service;

import com.knits.ammolite.model.company.Country;
import com.knits.ammolite.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    public Country getCountryByName(String name){
        if (repository.findByName(name).isEmpty()){
            return new Country(name);
        }
        return repository.findByName(name).get();
    }
}
