package com.boge.pibackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = "com.boge.pibackend")
@MapperScan(value = "com.boge.pibackend.dao",annotationClass = Repository.class)
public class IdeaSharingApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdeaSharingApplication.class, args);
    }

}
