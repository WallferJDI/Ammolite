package com.knits.ammolite.service.mapper.asset;

import com.knits.ammolite.model.procurement.Order;
import com.knits.ammolite.service.dto.asset.OrderDto;
import com.knits.ammolite.service.mapper.AbstractMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrderMapper extends AbstractMapper<OrderDto, Order> {
}
