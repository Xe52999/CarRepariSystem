package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VehicleMapper {
    //根据Client_id获取车辆信息
    List<Vehicle> getListByCId(Integer id);

    int containLicenseOrVin(String License,String Vin);

    int insertVehicle(Vehicle vehicle);

    int getVidByVin(String vin);

    Vehicle getVehicleByVehicleId(@Param("vehicleId") Integer vehicleId);

}
