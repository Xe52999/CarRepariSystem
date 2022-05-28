package com.shu.carsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairmanRecord {
    private Integer repairId;
    private String vin;
    private String license;
    private Integer proId;
    private String pname;
    private String failure;
    private Integer repairmanId;
}
