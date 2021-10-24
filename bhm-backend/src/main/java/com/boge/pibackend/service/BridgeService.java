package com.boge.pibackend.service;


import com.boge.pibackend.utils.ReturnData;

import java.util.Map;

public interface BridgeService {
    ReturnData addBridge(Map<String, Object> params);
    ReturnData removeBridge(Map<String, Object> params);
    ReturnData changeBridge(Map<String, Object> params);
    ReturnData listBridge(Map<String, Object> params);
}
