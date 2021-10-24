package com.boge.pibackend.controller;


import com.boge.pibackend.service.AlgorithmService;
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
@RequestMapping("/algorithm")
public class AlgorithmController {
    @Autowired
    AlgorithmService algorithmService;

    @ApiOperation("addAlgorithm")
    @PostMapping("/addAlgorithm")
    public ReturnResult addAlgorithm(@RequestBody Map<String, Object> params) {
        ReturnData result=algorithmService.addAlgorithm(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("removeAlgorithm")
    @PostMapping("/removeAlgorithm")
    public ReturnResult removeAlgorithm(@RequestBody Map<String, Object> params) {
        ReturnData result=algorithmService.removeAlgorithm(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("changeAlgorithm")
    @PostMapping("/changeAlgorithm")
    public ReturnResult changeAlgorithm(@RequestBody Map<String, Object> params){
        ReturnData result=algorithmService.changeAlgorithm(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

    @ApiOperation("listAlgorithm")
    @PostMapping("/listAlgorithm")
    public ReturnResult listAlgorithm(@RequestBody Map<String, Object> params){
        ReturnData result=algorithmService.listAlgorithm(params);
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),result);
    }

}
