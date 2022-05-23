package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientMapper {
    Client inquireClient(Client client);

    Client inquireClientByName(String id);

    int insertClient(Client client);

    int updatePasswordById(Integer id, String password);

    int updateInfoById(Integer id, String name, String nature, String contact, String phone);
}
