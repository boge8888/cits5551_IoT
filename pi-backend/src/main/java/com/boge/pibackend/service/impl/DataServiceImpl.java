package com.boge.pibackend.service.impl;

import com.boge.pibackend.dao.DataMapper;
import com.boge.pibackend.entity.Data;
import com.boge.pibackend.service.DataService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("DataService")
public class DataServiceImpl implements DataService {

    @Autowired
    DataMapper dataMapper;


    @Override
    public List<Data> displayData(Map<String, Object> params) {
        List<Data> datalist=dataMapper.selectAll();
        return datalist;
    }

    @Override
    public List<Data> getTenData(Map<String, Object> params) {
        List<Data> datalist=dataMapper.selectTen();
        return datalist;
    }
}
