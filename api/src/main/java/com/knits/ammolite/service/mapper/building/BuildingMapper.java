package com.knits.ammolite.service.mapper.building;

import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.model.building.Contact;
import com.knits.ammolite.model.building.Reception;
import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",imports = {Contact.class, SecurityContact.class, Reception.class, Location.class})
public interface BuildingMapper extends EntityMapper<Building,BuildingDto> {


}
