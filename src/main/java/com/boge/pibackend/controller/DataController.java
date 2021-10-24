package com.boge.pibackend.controller;

import com.boge.pibackend.entity.Data;
import com.boge.pibackend.service.DataService;
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
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @ApiOperation("getalldata")
    @PostMapping("/getalldata")
    public ReturnResult getAllData(@RequestBody Map<String, Object> params)
    {
        ReturnData datalist=dataService.displayData(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),datalist);
    }
    @ApiOperation("gettendata")
    @PostMapping("/gettendata")
    public ReturnResult getTenData(@RequestBody Map<String, Object> params)
    {
        ReturnData datalist=dataService.getTenData(params);// return 10 newest data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),datalist);
    }

    @ApiOperation("getalltowerdata")
    @PostMapping("/getalltowerdata")
    public ReturnResult getAllTowerData(@RequestBody Map<String, Object> params)
    {
        ReturnData datalist=dataService.displayTowerData(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),datalist);
    }
    @ApiOperation("gettentowerdata")
    @PostMapping("/gettentowerdata")
    public ReturnResult getTenTowerData(@RequestBody Map<String, Object> params)
    {
        ReturnData datalist=dataService.getTenTowerData(params);// return 10 newest data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),datalist);
    }

    @ApiOperation("getallcabledata")
    @PostMapping("/getallcabledata")
    public ReturnResult getAllCableData(@RequestBody Map<String, Object> params)
    {
        ReturnData datalist=dataService.displayCableData(params);//return all data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),datalist);
    }
    @ApiOperation("gettencabledata")
    @PostMapping("/gettencabledata")
    public ReturnResult getTenCableData(@RequestBody Map<String, Object> params)
    {
        ReturnData datalist=dataService.getTenCableData(params);// return 10 newest data
        return new ReturnResult(ReturnCode.SUCCESS.getCode(),datalist);
    }
}
