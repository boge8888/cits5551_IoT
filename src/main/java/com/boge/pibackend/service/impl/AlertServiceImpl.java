package com.boge.pibackend.service.impl;

import com.boge.pibackend.dao.BridgecabledataMapper;
import com.boge.pibackend.dao.UserMapper;
import com.boge.pibackend.entity.Bridgecabledata;
import com.boge.pibackend.entity.User;
import com.boge.pibackend.service.AlertService;
import com.boge.pibackend.service.MailService;
import com.boge.pibackend.utils.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("AlertService")
public class AlertServiceImpl implements AlertService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BridgecabledataMapper bridgecabledataMapper;

    @Autowired
    MailService mailService;


    @Override
    public ReturnData sendAlert(Map<String, Object> params) {
        User user = userMapper.selectByPrimaryKey(Long.valueOf(params.get("id").toString()));
        String to=user.getEmail1();
        mailService.send(to, "BHM Alert", UUID.randomUUID().toString().toUpperCase());
        ReturnData ret=new ReturnData();
        ret.setIsSend(1);
        return ret;
    }

    @Override
    public ReturnData sendSpecifiedAlert(Map<String, Object> params) {
        String to=(String)params.get("to");
        String subject=(String)params.get("subject");
        String text=(String)params.get("text");
        mailService.send(to, subject, text);
        ReturnData ret=new ReturnData();
        ret.setIsSend(1);
        return ret;
    }

    @Override
    public void sendScheduleAlert(Map<String, Object> params) {
//        dataMapper
//        User user = userMapper.selectByPrimaryKey(Long.valueOf(params.get("id").toString()));
        User user = userMapper.selectByPrimaryKey(1l);
        String to=user.getEmail1();
        List<Bridgecabledata> bridgecabledataList=bridgecabledataMapper.selectTen();
        String alertTime="2000-10-07 15:54:40";
        for(Bridgecabledata bridgecabledata:bridgecabledataList){
            if(bridgecabledata.getRisk_level()>=3){
                alertTime=bridgecabledata.getTime();
                break;
            }
        }
//        System.out.println(alertTime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(new Date());
        try {
            Date aa = df.parse(alertTime);
            Date bb=df.parse(nowTime);
            long alert = aa.getTime();
            long now=bb.getTime();
//            System.out.println(Math.abs(now-alert));
            if(Math.abs(now-alert)<100000)//unit: ms
                mailService.send(to, "BHM Alert", "Your risk level is greater than 3.");
//                mailService.send(to, "BHM Alert", UUID.randomUUID().toString().toUpperCase());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
