package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Client;
import com.shu.carsystem.entity.Maintain;
import com.shu.carsystem.pojo.NotEnsuredRepair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintainMapper {

    int insertMaintain(Maintain maintain);

    List<NotEnsuredRepair> getNotEnsuredRepairs(Integer userId, String keyWord);
}
