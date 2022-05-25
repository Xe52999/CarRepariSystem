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

    //返回所有 userId 为null 的 订单，即待接的订单
    List<Repair> showOrderToReceive();

    //返回所有 userId 不为null 的 订单，即处理中的订单
    List<Repair> showOrderInProgress();


    //修改订单中的userId
    int updateRepairByRepairId(@Param("userId") Integer userId,@Param("repairId") Integer repairId);

}
