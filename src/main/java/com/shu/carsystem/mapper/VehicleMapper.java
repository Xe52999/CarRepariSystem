package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleMapper {
    //根据Client_id获取车辆信息
    List<Vehicle> getListByCId(Integer id);
}
