package com.shu.carsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairVehicle {
    private Integer repairId;
    private String license;
    private String vin;
    private String category;
    private String failure;
    private String statu;
}
