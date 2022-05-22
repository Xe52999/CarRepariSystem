package com.shu.carsystem.service.Impl;

import com.shu.carsystem.mapper.ClientMapper;
import com.shu.carsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

}
