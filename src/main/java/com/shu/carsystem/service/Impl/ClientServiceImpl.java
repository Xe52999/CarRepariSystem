package com.shu.carsystem.service.Impl;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.entity.Client;
import com.shu.carsystem.mapper.ClientMapper;
import com.shu.carsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client inquireClient(Client client) {
        return clientMapper.inquireClient(client);
    }

    @Override
    public int insertClient(Client client) {
        return clientMapper.insertClient(client);
    }

    @Override
    public int updatePasswordById(Integer id, String password) {
        return clientMapper.updatePasswordById(id, password);
    }

    @Override
    public int updateInfoById(Integer id, String name, String nature, String contact, String phone) {
        return clientMapper.updateInfoById(id, name, nature, contact, phone);
    }

    @Override
    public Result addClientInfo(Map<String, Object> map) {
        //Client页面的Post请求分为两类：新增车辆和新增委托
        int cnt = 0;
        if(map.containsKey("license")){
            //请求参数包含车牌号，说明此为新增车辆请求。
            

        }
        else if(map.containsKey())
    }
}
