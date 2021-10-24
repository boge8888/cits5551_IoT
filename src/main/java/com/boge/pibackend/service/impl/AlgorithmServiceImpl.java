package com.boge.pibackend.service.impl;

import com.boge.pibackend.dao.AlgorithmMapper;
import com.boge.pibackend.service.AlgorithmService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("AlgorithmService")
public class AlgorithmServiceImpl implements AlgorithmService {

    @Autowired
    AlgorithmMapper algorithmMapper;

    @Override
    public ReturnData addAlgorithm(Map<String, Object> params) {
        return null;
    }

    @Override
    public ReturnData removeAlgorithm(Map<String, Object> params) {
        return null;
    }

    @Override
    public ReturnData changeAlgorithm(Map<String, Object> params) {
        return null;
    }

    @Override
    public ReturnData listAlgorithm(Map<String, Object> params) {
        return null;
    }
}
