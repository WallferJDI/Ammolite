package com.knits.ammolite.mapper.asset;

import com.knits.ammolite.dto.asset.OrderDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.procurement.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrderMapper extends EntityMapper<OrderDto, Order> {
}
