package com.knits.ammolite.service.mapper.building;

import com.knits.ammolite.model.location.Building;
import com.knits.ammolite.model.location.Contact;
import com.knits.ammolite.model.location.Reception;
import com.knits.ammolite.model.location.SecurityContact;
import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",imports = {Contact.class, SecurityContact.class, Reception.class, Location.class})
public interface BuildingMapper extends EntityMapper<Building,BuildingDto> {


}
