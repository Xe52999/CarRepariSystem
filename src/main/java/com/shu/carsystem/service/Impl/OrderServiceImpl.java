package com.shu.carsystem.service.Impl;

import com.shu.carsystem.mapper.OrderMapper;
import com.shu.carsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
}
