package com.shu.carsystem.service;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.entity.User;

public interface UserService {
    Result[] inquire(User user);

    Result inquireByName(String id);
    Result showRepairman(Integer pageNo,Integer pageSize,String keyword);
}
