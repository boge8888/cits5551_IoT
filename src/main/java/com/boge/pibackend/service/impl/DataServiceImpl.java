package com.boge.pibackend.service.impl;

import com.boge.pibackend.dao.BridgecabledataMapper;
import com.boge.pibackend.dao.BridgetowerdataMapper;
import com.boge.pibackend.dao.DataMapper;
import com.boge.pibackend.entity.Bridgecabledata;
import com.boge.pibackend.entity.Bridgetowerdata;
import com.boge.pibackend.entity.Data;
import com.boge.pibackend.service.DataService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("DataService")
public class DataServiceImpl implements DataService {

    @Autowired
    DataMapper dataMapper;

    @Autowired
    BridgetowerdataMapper bridgetowerdataMapper;

    @Autowired
    BridgecabledataMapper bridgecabledataMapper;


    @Override
    public ReturnData displayData(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
//        ret.setIsLoginSuccess(1);
        List<Data> datalist=dataMapper.selectAll();
        ret.setData(datalist);
        return ret;
    }

    @Override
    public ReturnData getTenData(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        List<Data> datalist=dataMapper.selectTen();
        ret.setData(datalist);
        return ret;
    }

    @Override
    public ReturnData displayTowerData(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        List<Bridgetowerdata> datalist=bridgetowerdataMapper.selectAll();
        ret.setBridgetowerdata(datalist);
        return ret;
    }

    @Override
    public ReturnData getTenTowerData(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        List<Bridgetowerdata> datalist=bridgetowerdataMapper.selectTen();
        ret.setBridgetowerdata(datalist);
        return ret;
    }

    @Override
    public ReturnData displayCableData(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        List<Bridgecabledata> datalist=bridgecabledataMapper.selectAll();
        ret.setBridgecabledata(datalist);
        return ret;
    }

    @Override
    public ReturnData getTenCableData(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        List<Bridgecabledata> datalist=bridgecabledataMapper.selectTen();
        ret.setBridgecabledata(datalist);
        return ret;
    }
}
