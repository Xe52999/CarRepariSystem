package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepairMapper {
    //根据Client_id获取车辆信息
    List<Repair> getListByUId(Integer id);

    //根据车架号vin查询是否存在对应委托
    Repair getRepairByVehicleId(Integer vehicleId);

    //将一个Client的Repair插入到表中
    int insertClientRepair(Repair repair);



    //返回所有待接的订单
    List<Repair> showRepairToReceive();

    //返回所有待分派的订单
    List<Repair> showRepairInProgress();

    //返回所有已经完成的订单
    List<Repair> showRepairComplete();

    //业务员 编辑 委托
    int updateRepair(Repair repair);

}
