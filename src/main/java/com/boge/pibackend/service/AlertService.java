package com.boge.pibackend.service;

import com.boge.pibackend.utils.ReturnData;

import java.util.Map;

public interface AlertService {
    ReturnData sendAlert(Map<String, Object> params);
    ReturnData sendSpecifiedAlert(Map<String, Object> params);
    void sendScheduleAlert(Map<String, Object> params);
}
