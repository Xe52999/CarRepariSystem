package com.shu.carsystem.service;

import com.shu.carsystem.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {
    Client inquireClient(Client client);

    int insertClient(Client client);

    int updatePasswordById(Integer id, String password);

    int updateInfoById(Integer id, String name, String nature, String contact, String phone);
}
