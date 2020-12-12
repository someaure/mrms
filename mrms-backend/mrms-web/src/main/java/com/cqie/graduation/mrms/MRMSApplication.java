package com.cqie.graduation.mrms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.cqie.graduation.mrms.*.mapper"})
public class MRMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(MRMSApplication.class, args);
    }
}
