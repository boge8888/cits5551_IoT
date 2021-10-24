package com.boge.pibackend.service.impl;
import com.boge.pibackend.dao.LogMapper;
import com.boge.pibackend.entity.Bridgetowerdata;
import com.boge.pibackend.entity.Log;
import com.boge.pibackend.service.LogService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("LogService")
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public ReturnData checkLog(Map<String, Object> params) {
        Log log=logMapper.selectByPrimaryKey(Long.valueOf(params.get("id").toString()));
        ReturnData ret=new ReturnData();
        return ret;
    }

    @Override
    public ReturnData addLog(Map<String, Object> params) {
        Log log=new Log();
        log.setBridge_id(Long.valueOf(params.get("bridge_id").toString()));
        log.setDevice_id(Long.valueOf(params.get("device_id").toString()));
        if(params.get("degree")!=null)
        log.setDegree(Integer.valueOf(params.get("degree").toString()));
        if(params.get("parameter")!=null)
        log.setParameter(Integer.valueOf(params.get("parameter").toString()));
        log.setDate(new java.sql.Date(new Date().getTime()));
        log.setTimestamp((String)params.get("timestamp"));
        logMapper.insert(log);
        ReturnData ret=new ReturnData();
        ret.setIsCreateSuccess(1);
        return ret;
    }

    @Override
    public ReturnData removeLog(Map<String, Object> params) {
        logMapper.deleteByPrimaryKey(Long.valueOf(params.get("id").toString()));
        ReturnData ret=new ReturnData();
        ret.setIsDeleteSuccess(1);
        return ret;
    }

    @Override
    public ReturnData changeLog(Map<String, Object> params) {
        Log log=new Log();
        log.setId(Long.valueOf(params.get("id").toString()));
        log.setBridge_id(Long.valueOf(params.get("bridge_id").toString()));
        log.setDevice_id(Long.valueOf(params.get("device_id").toString()));
        if(params.get("degree")!=null)
        log.setDegree(Integer.valueOf(params.get("degree").toString()));
        if(params.get("parameter")!=null)
        log.setParameter(Integer.valueOf(params.get("parameter").toString()));
        log.setDate(new java.sql.Date(new Date().getTime()));
        log.setTimestamp((String)params.get("timestamp"));
        logMapper.updateByPrimaryKey(log);
        ReturnData ret=new ReturnData();
        ret.setIsUpdateSuccess(1);
        return ret;
    }

    @Override
    public ReturnData listLog(Map<String, Object> params) {
        ReturnData ret=new ReturnData();
        List<Log> datalist=logMapper.selectAll();
        ret.setLogs(datalist);
        return ret;
    }
}
