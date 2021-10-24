package com.boge.pibackend.controller;


import com.boge.pibackend.service.DeviceService;
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

import java.util.Map;

@Api
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @ApiOperation("checkDevice")
    @PostMapping("/checkDevice")
    public ReturnResult checkDevice(@RequestBody Map<String, Object> params) {
        ReturnData result=deviceService.checkDevice(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("addDevice")
    @PostMapping("/addDevice")
    public ReturnResult addDevice(@RequestBody Map<String, Object> params) {
        ReturnData result=deviceService.addDevice(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("removeDevice")
    @PostMapping("/removeDevice")
    public ReturnResult removeDevice(@RequestBody Map<String, Object> params) {
        ReturnData result=deviceService.removeDevice(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("changeDevice")
    @PostMapping("/changeDevice")
    public ReturnResult changeDevice(@RequestBody Map<String, Object> params) {
        ReturnData result=deviceService.changeDevice(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("listDevice")
    @PostMapping("/listDevice")
    public ReturnResult listDevice(@RequestBody Map<String, Object> params) {
        ReturnData result=deviceService.listDevice(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }
}
