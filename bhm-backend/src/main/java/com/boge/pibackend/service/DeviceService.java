package com.boge.pibackend.service;


import com.boge.pibackend.utils.ReturnData;

import java.util.Map;

public interface DeviceService {
    ReturnData checkDevice(Map<String, Object> params);
    ReturnData addDevice(Map<String, Object> params);
    ReturnData removeDevice(Map<String, Object> params);
    ReturnData changeDevice(Map<String, Object> params);
    ReturnData listDevice(Map<String, Object> params);
}
