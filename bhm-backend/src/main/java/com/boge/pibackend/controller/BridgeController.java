package com.boge.pibackend.controller;


import com.boge.pibackend.service.BridgeService;
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
@RequestMapping("/bridge")
public class BridgeController {
    @Autowired
    BridgeService bridgeService;

    @ApiOperation("addBridge")
    @PostMapping("/addBridge")
    public ReturnResult addBridge(@RequestBody Map<String, Object> params) {
        ReturnData result=bridgeService.addBridge(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("removeBridge")
    @PostMapping("/removeBridge")
    public ReturnResult removeBridge(@RequestBody Map<String, Object> params) {
        ReturnData result=bridgeService.removeBridge(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("changeBridge")
    @PostMapping("/changeBridge")
    public ReturnResult changeBridge(@RequestBody Map<String, Object> params) {
        ReturnData result=bridgeService.changeBridge(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("listBridge")
    @PostMapping("/listBridge")
    public ReturnResult listBridge(@RequestBody Map<String, Object> params) {
        ReturnData result=bridgeService.listBridge(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }
}
