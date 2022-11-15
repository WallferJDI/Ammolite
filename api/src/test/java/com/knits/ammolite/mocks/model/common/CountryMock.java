package com.knits.ammolite.mocks.model.common;


import com.knits.ammolite.model.common.Country;

public class CountryMock {
    public static Country getCountryAllFields(Long id){
        return Country.builder()
                .id(id)
                .name("Country Name")
                .iso2("Iso 2")
                .iso3("Iso 3")
                .build();
    }
}
