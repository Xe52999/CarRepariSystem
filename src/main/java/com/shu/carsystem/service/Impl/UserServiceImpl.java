package com.shu.carsystem.service.Impl;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.User;
import com.shu.carsystem.mapper.UserMapper;
import com.shu.carsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //查询任意一位用户数据信息
    @Override
    public Result inquire(User user) {
        User user1 = userMapper.inquireUser(user);
        if(user1 == null) return Result.create(ResultEnum.USER_NOT_EXIST,null);
        return Result.create(ResultEnum.QUERY_SUCCESS, user1);
    }
}
