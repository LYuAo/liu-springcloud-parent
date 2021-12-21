package com.liu.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class ApplicationProvider2 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider2.class,args);
    }
}
