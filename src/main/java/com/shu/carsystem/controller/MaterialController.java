package com.shu.carsystem.controller;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.entity.Material;
import com.shu.carsystem.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping
    public Result insert(@RequestBody Material material){
        return materialService.insert(material);
    }
}
