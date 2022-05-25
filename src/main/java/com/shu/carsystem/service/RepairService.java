package com.shu.carsystem.service;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.entity.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RepairService {
    List<Repair> getListByUId(Integer id);


    Result showRepairToReceive(Integer pageNo,Integer pageSize);


    Result showRepairInProgress(Integer pageNo,Integer pageSize);

    Result showRepairComplete(Integer pageNo,Integer pageSize);


    Result updateRepair(Repair repair,Integer userId);

}
