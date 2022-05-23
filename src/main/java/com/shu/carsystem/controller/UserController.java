package com.shu.carsystem.controller;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Client;
import com.shu.carsystem.entity.User;
import com.shu.carsystem.entity.Vehicle;
import com.shu.carsystem.service.ClientService;
import com.shu.carsystem.service.Impl.UserServiceImpl;
import com.shu.carsystem.service.RepairService;
import com.shu.carsystem.service.UserService;
import com.shu.carsystem.service.VehicleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RepairService repairService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/login/{username}/{password}")
    private Result[] userLogin(@PathVariable("username") String username, @PathVariable("password") String password, HttpSession httpSession)
    {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        Result[] result = userService.inquire(user);
        if(result[0].getData() == null){
            Result[] ret = new Result[1];
            ret[0] = Result.create(ResultEnum.USER_NOT_EXIST,null);
            return ret;
        }
        Result[] dataReturn;
        if(result[1].getData().equals("Client")){
            Client client = (Client) result[0].getData();
            List<Vehicle> list = vehicleService.getListByCId(client.getClientId());
            dataReturn = new Result[list.size() + 2];
            dataReturn[0] = Result.create(ResultEnum.QUERY_SUCCESS, client);
            dataReturn[1] = Result.create(ResultEnum.QUERY_SUCCESS, "Client");
            int t = 2;
            for(Vehicle i : list){
                dataReturn[t++] = Result.create(ResultEnum.VEHICLE_DATA, i);
            }
        }
        else{
            user = (User) result[0].getData();
            dataReturn = new Result[1];
            if(user.getIsRepairman() == 1){
                /*
                    未完成：获取对应数据
                 */

            }
        }

        return dataReturn;
    }

    @PostMapping("/registry")
    private Result userRegistry(@RequestBody Client client){
        // 客户注册功能
        // 获取账号和密码，首先判断账号是否已存在，账号存在则返回用户已存在，否则返回插入成功
        System.out.println(client);
        Result result = userService.inquireByName(client.getClientId2());
        //数据库存在相同的账号就返回账号已存在
        if(result.getCode() == ResultEnum.USER_IS_EXISTS.getCode()){
            return Result.create(ResultEnum.USER_IS_EXISTS,null);
        }

        //否则就插入数据，返回该用户数据信息
        int res = clientService.insertClient(client);
        if(res == 0) return Result.create(ResultEnum.UNKNOWN_ERROR,null);
        return Result.create(ResultEnum.SUCCESS,client);
    }

}
