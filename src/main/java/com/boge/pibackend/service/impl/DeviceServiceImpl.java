package com.boge.pibackend.service.impl;
import com.boge.pibackend.dao.DeviceMapper;
import com.boge.pibackend.entity.Bridge;
import com.boge.pibackend.entity.Device;
import com.boge.pibackend.service.DeviceService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("DeviceService")
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public ReturnData checkDevice(Map<String, Object> params) {
        Device device=deviceMapper.selectByPrimaryKey(Long.valueOf(params.get("id").toString()));
        ReturnData ret=new ReturnData();
        return ret;
    }

    @Override
    public ReturnData addDevice(Map<String, Object> params) {
        Device device=new Device();
        device.setType((String)params.get("type"));
        device.setDate(new java.sql.Date(new Date().getTime()));
        device.setLocation((String)params.get("location"));
        device.setBridge_id(Long.valueOf(params.get("bridge_id").toString()));
        device.setBridge((String)params.get("bridge"));
        device.setUser_id(Long.valueOf(params.get("user_id").toString()));
        if(params.get("status")!=null)
        device.setStatus(Integer.valueOf(params.get("status").toString()));
        deviceMapper.insert(device);
        ReturnData ret=new ReturnData();
        ret.setIsCreateSuccess(1);
        return ret;
    }

    @Override
    public ReturnData removeDevice(Map<String, Object> params) {
        deviceMapper.deleteByPrimaryKey(Long.valueOf(params.get("id").toString()));
        ReturnData ret=new ReturnData();
        ret.setIsDeleteSuccess(1);
        return ret;
    }

    @Override
    public ReturnData changeDevice(Map<String, Object> params) {
        Device device=new Device();
        device.setId(Long.valueOf(params.get("id").toString()));
        device.setType((String)params.get("type"));
        device.setDate(new java.sql.Date(new Date().getTime()));
        device.setLocation((String)params.get("location"));
        device.setBridge_id(Long.valueOf(params.get("bridge_id").toString()));
        device.setBridge((String)params.get("bridge"));
        device.setUser_id(Long.valueOf(params.get("user_id").toString()));
        if(params.get("status")!=null)
            device.setStatus(Integer.valueOf(params.get("status").toString()));
        deviceMapper.updateByPrimaryKey(device);
        ReturnData ret=new ReturnData();
        ret.setIsUpdateSuccess(1);
        return ret;
    }

    @Override
    public ReturnData listDevice(Map<String, Object> params) {
        List<Device> deviceList=deviceMapper.selectAll();
        ReturnData ret=new ReturnData();
        ret.setDevices(deviceList);
        return ret;
    }
}
