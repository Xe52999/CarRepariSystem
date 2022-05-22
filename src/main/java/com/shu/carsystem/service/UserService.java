package com.shu.carsystem.service;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.entity.User;

public interface UserService {
    Result[] inquire(User user);

    Result inquireById(Integer id);
}
