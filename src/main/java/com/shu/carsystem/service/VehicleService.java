package com.shu.carsystem.service;

import com.shu.carsystem.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getListByCId(Integer id);
}
