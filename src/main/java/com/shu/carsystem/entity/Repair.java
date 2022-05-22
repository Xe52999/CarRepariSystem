package com.shu.carsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Repair {
    private Integer repairId;
    private String type;
    private String classification;
    private String payment;
    private Double mile;
    private Double fuel;
    private String approachTime;
    private String failure;
    private String ddl;
    private Integer cost;
}
