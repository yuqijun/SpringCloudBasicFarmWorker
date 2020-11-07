package com.dijiang.staff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.dijiang.staff.mybatisplus")
@ComponentScan(basePackages = {"com.dijiang.staff.interfacer","com.dijiang.common.service","com.dijiang.staff.controller","com.dijiang.common.exception","com.dijiang.staff.mybatisplus.sys.service","com.dijiang.staff.component"})
@EnableDiscoveryClient
@EnableFeignClients
@Configuration("com.dijiang.staff.interfacer")
public class StaffManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffManagementApplication.class, args);
    }

}
