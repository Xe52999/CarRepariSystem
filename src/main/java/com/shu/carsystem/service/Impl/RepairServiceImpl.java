package com.shu.carsystem.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.entity.User;
import com.shu.carsystem.entity.Vehicle;
import com.shu.carsystem.mapper.RepairMapper;
import com.shu.carsystem.mapper.UserMapper;
import com.shu.carsystem.mapper.VehicleMapper;
import com.shu.carsystem.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public List<Repair> getListByUId(Integer id) {
        return repairMapper.getListByUId(id);
    }

    @Override
    public Result showRepairToReceive(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Repair> repairs = repairMapper.showRepairToReceive();
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairs);
        return Result.create(ResultEnum.QUERY_SUCCESS,repairPageInfo);
    }


    @Override
    public Result showRepairInProgress(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Repair> repairs = repairMapper.showRepairInProgress();
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairs);
        return Result.create(ResultEnum.QUERY_SUCCESS,repairPageInfo);
    }

    @Override
    public Result showRepairComplete(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Repair> repairs = repairMapper.showRepairComplete();
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairs);
        return Result.create(ResultEnum.QUERY_SUCCESS,repairPageInfo);
    }

    @Override
    public Result updateRepair(Repair repair,Integer userId) {
        repair.setStatu("等待派单"); //修改状态
        repair.setUserId(userId);   //设置业务员编号

        /**
         * 更新之前 要先判断，userId vechiledId maintainId 是否存在，若不存在则说明，非法，不予更新，并且返回错位信息
         */
        User user = userMapper.inqurieUserByUserId(userId);
        if(user == null) return Result.create(ResultEnum.USER_NOT_EXIST,userId);
        Vehicle vehicle = vehicleMapper.getVehicleByVehicleId(repair.getVehicleId());
        if(vehicle == null) return Result.create(ResultEnum.Vehicle_NOT_EXISTS,repair.getVehicleId());

        int i = repairMapper.updateRepair(repair);//更新
        if(i==0) return Result.create(ResultEnum.UPDATE_ERROR,repair);
        else return Result.create(ResultEnum.UPDATE_SUCCESS,repair);
    }


}
