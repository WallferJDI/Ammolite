package com.knits.ammolite.mokcs.model;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.building.Contact;
import com.knits.ammolite.model.building.Reception;
import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.model.location.Country;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.model.location.OwnershipType;
import com.knits.ammolite.model.location.RealEstateType;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.dto.building.ContactDto;
import com.knits.ammolite.service.dto.building.ReceptionDto;
import com.knits.ammolite.service.dto.building.SecurityContactDto;
import com.knits.ammolite.service.dto.location.CountryDto;
import com.knits.ammolite.service.dto.location.LocationDto;

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
                .building(new Building(1l,new Location(1l,"A mock Location",new Country(1l,"A mock Country",new ArrayList<>()),"A mock Address","A mock zipCode",OUR_PREMISES,false,"A mock Longitude","A mock Longitude", OFFICE ,false)
                        ,new Contact(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new SecurityContact(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new Reception(1l,"A mock Fax,","A mock Phone"),false,OFFICE,"A mock Address"))
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
