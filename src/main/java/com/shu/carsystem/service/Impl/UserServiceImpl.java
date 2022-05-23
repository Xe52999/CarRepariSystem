package com.shu.carsystem.service.Impl;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Client;
import com.shu.carsystem.entity.User;
import com.shu.carsystem.mapper.ClientMapper;
import com.shu.carsystem.mapper.UserMapper;
import com.shu.carsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClientMapper clientMapper;


    //查询任意一位用户数据信息（思路：分别在Client和User表中查询）
    @Override
    public Result[] inquire(User user) {
        User user1 = userMapper.inquireUser(user);
        Result[] ret = new Result[2];
        if(user1 == null){

            Client client = new Client();
            client.setClientId2(user.getName());
            client.setPassword(user.getPassword());
            System.out.println(client);
            Client client1 = clientMapper.inquireClient(client);
            System.out.println(client1);
            if(client1 == null) {
                ret[0] = Result.create(ResultEnum.USER_NOT_EXIST,null);
                return ret;
            }

            ret[0] = Result.create(ResultEnum.QUERY_SUCCESS, client1);
            ret[1] = Result.create(ResultEnum.QUERY_SUCCESS, "Client");
            return ret;
        }

        ret[0] = Result.create(ResultEnum.QUERY_SUCCESS, user1);
        ret[1] = Result.create(ResultEnum.QUERY_SUCCESS, "User");
        return ret;
    }

    @Override
    public Result inquireByName(String id) {
        // 不传数据只传结果
        User user = userMapper.inquireUserByName(id);
        if(user == null){
            Client client = clientMapper.inquireClientByName(id);
            if(client == null) return Result.create(ResultEnum.USER_NOT_EXIST, null);
            return Result.create(ResultEnum.USER_IS_EXISTS, null);
        }
        return Result.create(ResultEnum.USER_IS_EXISTS,null);
    }
}
