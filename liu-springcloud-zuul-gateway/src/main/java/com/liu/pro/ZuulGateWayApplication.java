package com.liu.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy   //开启路由
public class ZuulGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication.class,args);
    }
}
