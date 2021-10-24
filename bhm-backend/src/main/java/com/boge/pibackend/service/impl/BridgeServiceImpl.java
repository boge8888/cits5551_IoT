package com.boge.pibackend.service.impl;
import com.boge.pibackend.dao.BridgeMapper;
import com.boge.pibackend.entity.Bridge;
import com.boge.pibackend.service.BridgeService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("BridgeService")
public class BridgeServiceImpl implements BridgeService {

    @Autowired
    BridgeMapper bridgeMapper;

    @Override
    public ReturnData addBridge(Map<String, Object> params) {
        Bridge bridge=new Bridge();
        bridge.setName((String)params.get("name"));
        bridge.setType((String)params.get("type"));
        bridge.setLocation((String)params.get("location"));
        bridge.setDescription((String)params.get("description"));
        if(params.get("status")!=null)
        bridge.setStatus(Integer.valueOf(params.get("status").toString()));
        bridge.setDate(new java.sql.Date(new Date().getTime()));
        bridgeMapper.insert(bridge);
        ReturnData ret=new ReturnData();
        ret.setIsCreateSuccess(1);
        return ret;
    }

    @Override
    public ReturnData removeBridge(Map<String, Object> params) {
        bridgeMapper.deleteByPrimaryKey(Long.valueOf(params.get("id").toString()));
        ReturnData ret=new ReturnData();
        ret.setIsDeleteSuccess(1);
        return ret;
    }

    @Override
    public ReturnData changeBridge(Map<String, Object> params) {
        Bridge bridge=new Bridge();
        bridge.setId(Long.valueOf(params.get("id").toString()));
        bridge.setName((String)params.get("name"));
        bridge.setType((String)params.get("type"));
        bridge.setLocation((String)params.get("location"));
        bridge.setDescription((String)params.get("description"));
        if(params.get("status")!=null)
        bridge.setStatus(Integer.valueOf(params.get("status").toString()));
        bridge.setDate(new java.sql.Date(new Date().getTime()));
        bridgeMapper.updateByPrimaryKey(bridge);
        ReturnData ret=new ReturnData();
        ret.setIsUpdateSuccess(1);
        return ret;
    }

    @Override
    public ReturnData listBridge(Map<String, Object> params) {
        List<Bridge> bridgeList=bridgeMapper.selectAll();
        ReturnData ret=new ReturnData();
        ret.setBridges(bridgeList);
        return ret;
    }
}
