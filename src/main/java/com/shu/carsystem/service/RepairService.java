package com.shu.carsystem.service;

import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.entity.Vehicle;

import java.util.List;

public interface RepairService {
    List<Repair> getListByUId(Integer id);
}
