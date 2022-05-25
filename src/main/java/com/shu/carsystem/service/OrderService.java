package com.shu.carsystem.service;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.entity.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
    @Transactional
    Result insertOrder(Integer userId,Integer repairId);
}
