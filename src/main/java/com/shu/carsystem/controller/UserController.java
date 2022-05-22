package com.shu.carsystem.controller;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.User;
import com.shu.carsystem.service.Impl.UserServiceImpl;
import com.shu.carsystem.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/{password}")
    private Result userLogin(@PathVariable("userId") Integer id, @PathVariable("password") String password, HttpSession httpSession)
    {
        User user = new User(id, password);
        Result result = userService.inquire(user);
        if(result.getData() != null) {
            User user2 = (User) result.getData();
            httpSession.setAttribute("loginId", user2.getUserId());
            httpSession.setAttribute("loginName", user2.getName());
            httpSession.setAttribute("loginPhone",user2.getPhone());
            httpSession.setAttribute("is_admin?" , user.getIsAdmin());
            httpSession.setAttribute("is_repairman?", user2.getIsRepairman());
        }
        return result;
    }
}
