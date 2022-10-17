/*
package com.knits.ammolite.service;

import com.knits.ammolite.model.organization.Country;
import com.knits.ammolite.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Country getCountryByName(String name){
        Country country = new Country();
        if (repository.findByName(name).isEmpty()){
            return new Country(name);
        }
        return repository.findByName(name).get();
    }
}
*/
