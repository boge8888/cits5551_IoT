package com.boge.pibackend.controller;

import com.boge.pibackend.entity.Data;
import com.boge.pibackend.service.DataService;
import com.boge.pibackend.service.UserService;
import com.boge.pibackend.utils.ReturnCode;
import com.boge.pibackend.utils.ReturnData;
import com.boge.pibackend.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("register")
    @PostMapping("/register")
    public ReturnResult register(@RequestBody Map<String, Object> params)
    {
        ReturnData result=userService.register(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("login")
    @PostMapping("/login")
    public ReturnResult login(@RequestBody Map<String, Object> params)
    {
        ReturnData result=userService.login(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("getInfo")
    @PostMapping("/getInfo")
    public ReturnResult getInfo(@RequestBody Map<String, Object> params)
    {
        ReturnData result=userService.getUserDetails(params);//return info
//        return new ReturnResult(result==null?ReturnCode.NOTFOUND.getCode():ReturnCode.SUCCESS.getCode(),result);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("update")
    @PostMapping("/update")
    public ReturnResult update(@RequestBody Map<String, Object> params)
    {
        ReturnData result=userService.update(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

//    @ApiOperation("getalldata")
//    @PostMapping("/getalldata")
//    public List<Data> getAllData(@RequestBody Map<String, Object> params)
//    {
//        List<Data> datalist=dataService.displayData(params);//return all data
//        return datalist;
//    }
//    @ApiOperation("gettendata")
//    @PostMapping("/gettendata")
//    public List<Data> getTenData(@RequestBody Map<String, Object> params)
//    {
//        List<Data> datalist=dataService.getTenData(params);// return 10 newest data
//        return datalist;
//    }
}
