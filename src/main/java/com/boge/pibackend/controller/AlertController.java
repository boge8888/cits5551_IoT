package com.boge.pibackend.controller;
import com.boge.pibackend.service.AlertService;
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
@RequestMapping("/alert")
public class AlertController {
    @Autowired
    AlertService alertService;

    @ApiOperation("sendalert")
    @PostMapping("/sendalert")
    public ReturnResult sendAlert(@RequestBody Map<String, Object> params) {
        ReturnData result=alertService.sendAlert(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("sendspecifiedalert")
    @PostMapping("/sendspecifiedalert")
    public ReturnResult sendSpecifiedAlert(@RequestBody Map<String, Object> params) {
        ReturnData result=alertService.sendSpecifiedAlert(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }
}
