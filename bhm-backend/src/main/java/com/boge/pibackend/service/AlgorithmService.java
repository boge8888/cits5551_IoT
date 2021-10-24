package com.boge.pibackend.service;


import com.boge.pibackend.utils.ReturnData;

import java.util.Map;

public interface AlgorithmService {


    ReturnData addAlgorithm(Map<String, Object> params);
    ReturnData removeAlgorithm(Map<String, Object> params);
    ReturnData changeAlgorithm(Map<String, Object> params);
    ReturnData listAlgorithm(Map<String, Object> params);

}
