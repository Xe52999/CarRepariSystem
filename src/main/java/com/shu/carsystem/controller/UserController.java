package com.shu.carsystem.controller;

import com.shu.carsystem.common.Result;
import com.shu.carsystem.common.ResultEnum;
import com.shu.carsystem.entity.Client;
import com.shu.carsystem.entity.Repair;
import com.shu.carsystem.entity.User;
import com.shu.carsystem.entity.Vehicle;
import com.shu.carsystem.pojo.ClientIdUser;
import com.shu.carsystem.service.ClientService;
import com.shu.carsystem.service.*;
import com.shu.carsystem.service.Impl.UserServiceImpl;
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
            dataReturn = new Result[((list.size()==0) ? 0 : 1) + 2];
            dataReturn[0] = Result.create(ResultEnum.QUERY_SUCCESS, client);
            dataReturn[1] = Result.create(ResultEnum.QUERY_SUCCESS, "Client");
            if(list.size() != 0) dataReturn[2] = Result.create(ResultEnum.VEHICLE_DATA, list);
        }
        else{
            user = (User) result[0].getData();
            ClientIdUser clientIdUser = new ClientIdUser(user);
            dataReturn = new Result[2];
            dataReturn[0] = Result.create(ResultEnum.QUERY_SUCCESS, clientIdUser);
            if(user.getIsRepairman() == 1) dataReturn[1] = Result.create(ResultEnum.QUERY_SUCCESS, "RepairMan");
            else dataReturn[1] = Result.create(ResultEnum.QUERY_SUCCESS, "User");
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


    @GetMapping("/show/repair/receive/{pageNo}/{pageSize}/{keyword}")
    public Result showRepairToReceive(@PathVariable("pageNo") Integer pageNo,
                                      @PathVariable("pageSize") Integer pageSize,
                                      @PathVariable("keyword") String keyword){

        return repairService.showRepairToReceive(pageNo,pageSize,keyword);
    }
    @GetMapping("/show/repair/progress/{pageNo}/{pageSize}/{keyword}")
    public Result showRepairInProgress(@PathVariable("pageNo") Integer pageNo,
                                       @PathVariable("pageSize") Integer pageSize,
                                       @PathVariable("keyword") String keyword){
        return repairService.showRepairInProgress(pageNo,pageSize,keyword);
    }

    @GetMapping("/show/repair/complete/{pageNo}/{pageSize}/{keyword}")
    public Result showRepairComplete(@PathVariable("pageNo") Integer pageNo,
                                     @PathVariable("pageSize") Integer pageSize,
                                     @PathVariable("keyword") String keyword){
        return repairService.showRepairComplete(pageNo,pageSize,keyword);
    }
    @PutMapping("/repair/{userId}")
    public Result updateRepair(@RequestBody Repair repair, @PathVariable("userId") Integer userId){
        return repairService.updateRepair(repair,userId);

    }

    @GetMapping("/show/repairman/{pageNo}/{pageSize}/{keyword}")
    public Result showRepairman(@PathVariable("pageNo") Integer pageNo,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("keyword") String keyword){
        return userService.showRepairman(pageNo,pageSize,keyword);
    }

    @GetMapping("/show/client/{pageNo}/{pageSize}/{keyword}")
    public Result showClient(@PathVariable("pageNo") Integer pageNo,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("keyword") String keyword){
        return clientService.showClient(pageNo,pageSize,keyword);
    }

    @PutMapping("/client/update")
    public Result updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }


    @GetMapping("/show/repair/{pageNo}/{pageSize}/{keyword}")
    public Result showAllRepair(@PathVariable("pageNo") Integer pageNo,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("keyword") String keyword){

        return repairService.showAllRepair(pageNo,pageSize,keyword);
    }
}
