package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MaterialMapper {
    int insert(Material material);
}
