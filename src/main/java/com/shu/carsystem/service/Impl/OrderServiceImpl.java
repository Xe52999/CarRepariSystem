package com.shu.carsystem.service.Impl;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Order;
import com.shu.carsystem.mapper.OrderMapper;
import com.shu.carsystem.mapper.RepairMapper;
import com.shu.carsystem.service.OrderService;
import com.shu.carsystem.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RepairMapper repairMapper;

    @Override
    public Result insertOrder(Integer userId,Integer repairId) {
        /**
         * 接单操作两步：
         * 一：修改repair 委托为 处理中
         * 二：生成一个订单order （初始只有repair_id 和 order_id） 插入到order表
         */

        int i = repairMapper.updateRepairByRepairId(userId, repairId);
        if(i == 0) return Result.create(ResultEnum.UPDATE_ERROR,repairId);

        Order order = new Order();
        order.setRepairId(repairId);
        int insertOrder = orderMapper.insertOrder(order);
        if(insertOrder == 0) return Result.create(ResultEnum.INSERT_ERROR,null);
        else  return Result.create(ResultEnum.INSERT_SUCCESS,order);
    }
}
