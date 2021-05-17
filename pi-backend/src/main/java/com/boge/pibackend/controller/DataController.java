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
    public List<Data> getAllData(@RequestBody Map<String, Object> params)
    {
        List<Data> datalist=dataService.displayData(params);//return all data
        return datalist;
    }
    @ApiOperation("gettendata")
    @PostMapping("/gettendata")
    public List<Data> getTenData(@RequestBody Map<String, Object> params)
    {
        List<Data> datalist=dataService.getTenData(params);// return 10 newest data
        return datalist;
    }
}
