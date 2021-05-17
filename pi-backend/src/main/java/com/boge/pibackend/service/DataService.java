package com.boge.pibackend.service;

import com.boge.pibackend.entity.Data;
import com.boge.pibackend.utils.ReturnData;

import java.util.List;
import java.util.Map;

public interface DataService {

    List<Data> displayData(Map<String, Object> params);
    List<Data> getTenData(Map<String, Object> params);

}
