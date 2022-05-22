package com.shu.carsystem.service.Impl;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Material;
import com.shu.carsystem.mapper.MaterialMapper;
import com.shu.carsystem.service.MaterialService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public Result insert(Material material) {
        int insert = materialMapper.insert(material);
        if(insert == 0) return Result.create(ResultEnum.INSERT_ERROR,material);
        else return Result.create(ResultEnum.INSERT_SUCCESS,material);
    }

}
