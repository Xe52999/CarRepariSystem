package com.shu.carsystem.mapper;

import com.shu.carsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    User inquireUser(User user);

    User inquireUserByName(String id);

    User inqurieUserByUserId(@Param("UserId") Integer userId);
}