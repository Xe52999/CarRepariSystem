package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Client;
import com.shu.carsystem.entity.Maintain;
import com.shu.carsystem.pojo.NotEnsuredRepair;
import com.shu.carsystem.pojo.RepairmanRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface MaintainMapper {

    int insertMaintain(Maintain maintain);

    List<NotEnsuredRepair> getNotEnsuredRepairs(@Param("userId") Integer userId,@Param("keyWord") String keyWord);

    int affirmMaintain(@Param("repairmanRecord") RepairmanRecord repairmanRecord);
}
