package com.knits.ammolite.mocks.model;

import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.model.location.Building;
import com.knits.ammolite.model.location.Contact;
import com.knits.ammolite.model.location.Reception;
import com.knits.ammolite.model.location.SecurityContact;
import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.location.Location;


import java.util.ArrayList;
import java.util.List;

import static com.knits.ammolite.model.location.OwnershipType.OUR_PREMISES;
import static com.knits.ammolite.model.location.RealEstateType.OFFICE;


public class FloorMock {
    public static Floor shallowFloor(Long id){

        return Floor.builder()
                .id(id)
                .floorNumber("1")
                .realEstate(OFFICE)
                .building(new Building(1L,new Location(1L,"A mock Location",new Country(1L,"A mock Country",new ArrayList<>()),"A mock Address","A mock zipCode", OUR_PREMISES,false,"A mock Longitude","A mock Longitude", OFFICE,false)
                        ,new Contact(1L,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new SecurityContact(1L,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new Reception(1L,"A mock Fax,","A mock Phone"),false, OFFICE,"A mock Address"))
                .isDeleted(false)
                .build();
    }

    public static List<Floor> shallowListOfFloors(int howMany){
        List<Floor> mockFloors = new ArrayList<>();
        for (int i=0;i<howMany; i++){
            mockFloors.add(shallowFloor(Long.valueOf(i)));
        }
        return mockFloors;
    }
}
