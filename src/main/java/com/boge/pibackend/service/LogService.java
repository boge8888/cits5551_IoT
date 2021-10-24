package com.boge.pibackend.service;


import com.boge.pibackend.utils.ReturnData;

import java.util.Map;

public interface LogService {
    ReturnData checkLog(Map<String, Object> params);
    ReturnData addLog(Map<String, Object> params);
    ReturnData removeLog(Map<String, Object> params);
    ReturnData changeLog(Map<String, Object> params);
    ReturnData listLog(Map<String, Object> params);
}
