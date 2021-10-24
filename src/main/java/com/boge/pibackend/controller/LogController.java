package com.boge.pibackend.controller;


import com.boge.pibackend.service.LogService;
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
@RequestMapping("/log")
public class LogController {
    @Autowired
    LogService logService;

    @ApiOperation("checkLog")
    @PostMapping("/checkLog")
    public ReturnResult checkLog(@RequestBody Map<String, Object> params) {
        ReturnData result=logService.checkLog(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("addLog")
    @PostMapping("/addLog")
    public ReturnResult addLog(@RequestBody Map<String, Object> params) {
        ReturnData result=logService.addLog(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("removeLog")
    @PostMapping("/removeLog")
    public ReturnResult removeLog(@RequestBody Map<String, Object> params) {
        ReturnData result=logService.removeLog(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("changeLog")
    @PostMapping("/changeLog")
    public ReturnResult changeLog(@RequestBody Map<String, Object> params) {
        ReturnData result=logService.changeLog(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("listLog")
    @PostMapping("/listLog")
    public ReturnResult listLog(@RequestBody Map<String, Object> params) {
        ReturnData result=logService.listLog(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }
}
