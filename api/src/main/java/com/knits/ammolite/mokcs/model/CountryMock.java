package com.knits.ammolite.mokcs.model;

import com.knits.ammolite.model.location.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryMock {

    public static Country shallowCountry(Long id){

        return Country.builder()
                .id(id)
                .title("A mock Title")
                .build();
    }

    public static List<Country> shallowListOfCountry(int howMany){
        List<Country> mockCountry = new ArrayList<>();
        for (int i=0;i<howMany; i++){
            mockCountry.add(shallowCountry(Long.valueOf(i)));
        }
        return mockCountry;
    }
}
