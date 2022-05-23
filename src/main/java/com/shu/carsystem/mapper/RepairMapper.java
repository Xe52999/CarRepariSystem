package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairMapper {
    //根据Client_id获取车辆信息
    List<Repair> getListByUId(Integer id);

    //根据车架号vin查询是否存在对应委托
    Repair getRepairByVehicleId(Integer vehicleId);

    //将一个Client的Repair插入到表中
    int insertClientRepair(Repair repair);
}
