package com.shu.carsystem.service.Impl;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.mapper.RepairMapper;
import com.shu.carsystem.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;

    @Override
    public List<Repair> getListByUId(Integer id) {
        return repairMapper.getListByUId(id);
    }

    @Override
    public Result showOrderToReceive() {
        List<Repair> repairs = repairMapper.showOrderToReceive();
        //分页未实现，应该封装的是pageInfo
        return Result.create(ResultEnum.QUERY_SUCCESS,repairs);
    }

    @Override
    public Result showOrderInProgress() {
        List<Repair> repairs = repairMapper.showOrderInProgress();
        //分页未实现，应该封装的是pageInfo
        return Result.create(ResultEnum.QUERY_SUCCESS,repairs);
    }
}
