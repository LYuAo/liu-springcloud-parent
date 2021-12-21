package com.liu.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class ApplicationProvider4 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider4.class,args);
    }
}
