package com.boge.pibackend;

import com.boge.pibackend.IdeaSharingApplication;
import com.boge.pibackend.service.MailService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IdeaSharingApplication.class})
//@SpringBootApplication(scanBasePackages = "com.boge.pibackend")
//@MapperScan(value = "com.boge.pibackend.dao",annotationClass = Repository.class)
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Test
    public void testSend() {
        String to = "3021365231@qq.com";
        mailService.send(to, "Template email", UUID.randomUUID().toString().toUpperCase());
    }
}
