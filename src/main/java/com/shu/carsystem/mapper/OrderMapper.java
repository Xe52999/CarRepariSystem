package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    //插入一条订单
    int insertOrder(Order order);
}
