package com.knits.ammolite.mokcs.model;

import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.building.Contact;
import com.knits.ammolite.model.building.Reception;
import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.model.location.Country;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.model.location.OwnershipType;
import com.knits.ammolite.model.location.RealEstateType;

import java.util.ArrayList;
import java.util.List;

public class BuildingMock {

    public static Building shallowBuilding(Long id){

        return Building.builder()
                .id(id)
                .location(new Location(1l,"A mock Location",new Country(1l,"A mock Title",new ArrayList<>()),"A mock Address","A mock zipCode",OwnershipType.OUR_PREMISES,false,"A mock Longitude","A mock Longitude",RealEstateType.OFFICE,false))
                .contact(new Contact(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone"))
                .security(new SecurityContact(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone"))
                .reception(new Reception(1l,"A mock Fax,","A mock Phone"))
                .isDeleted(false)
                .build();
    }

    public static List<Building> shallowListOfBuilding(int howMany){
        List<Building> mockBuildings = new ArrayList<>();
        for (int i=0;i<howMany; i++){
            mockBuildings.add(shallowBuilding(Long.valueOf(i)));
        }
        return mockBuildings;
    }
}
