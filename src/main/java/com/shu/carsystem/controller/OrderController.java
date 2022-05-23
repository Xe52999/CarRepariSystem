package com.shu.carsystem.controller;

import com.shu.carsystem.service.Impl.OrderServiceImpl;
import com.shu.carsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
}
