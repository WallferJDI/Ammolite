package com.knits.ammolite.mokcs.model;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.WorkArea;
import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.building.Contact;
import com.knits.ammolite.model.building.Reception;
import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.model.location.Country;
import com.knits.ammolite.model.location.Location;

import java.util.ArrayList;
import java.util.List;

import static com.knits.ammolite.model.location.OwnershipType.OUR_PREMISES;
import static com.knits.ammolite.model.location.RealEstateType.OFFICE;
import static com.knits.ammolite.mokcs.model.FloorMock.shallowFloor;

public class WorkAreaMock {

    public static WorkArea shallowWorkArea(Long id){

        return WorkArea.builder()
                .id(id)
                .roomNumber("1")
                .realEstate(OFFICE)
                .floor(new Floor(1L,"1",OFFICE, new Building(1L,new Location(1L,"A mock Location",new Country(1L,"A mock Country",new ArrayList<>()),"A mock Address","A mock zipCode", OUR_PREMISES,false,"A mock Longitude","A mock Longitude", OFFICE,false)
                        ,new Contact(1L,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new SecurityContact(1L,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new Reception(1L,"A mock Fax,","A mock Phone"),false, OFFICE,"A mock Address"),false))
                .isDeleted(false)
                .build();
    }

    public static List<WorkArea> shallowListOfWorkAreas(int howMany){
        List<WorkArea> mockWorkAreas = new ArrayList<>();
        for (int i=0;i<howMany; i++){
            mockWorkAreas.add(shallowWorkArea(Long.valueOf(i)));
        }
        return mockWorkAreas;
    }
}
