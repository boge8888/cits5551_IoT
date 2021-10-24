package com.boge.pibackend.utils;

import com.boge.pibackend.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Map;

@Configuration
@EnableScheduling
public class SaticScheduleTask {
//    @Scheduled(cron = "0/5 * * * * ?")
    @Autowired
    AlertService alertService;

    @Scheduled(cron = "0 */1 * * * ?")//1 min
    //Or directly specify the time interval, for example: 5 seconds
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("Time to execute static scheduled tasks: " + LocalDateTime.now());
        Map<String, Object> params=null;
        alertService.sendScheduleAlert(params);
    }
}
