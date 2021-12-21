package com.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 开启Dashboard
@EnableHystrixDashboard
public class ApplicationDashboard {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDashboard.class,args);
    }
}
