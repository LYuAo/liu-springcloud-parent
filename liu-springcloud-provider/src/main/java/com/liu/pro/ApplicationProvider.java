package com.liu.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class ApplicationProvider {
    public static void main(String[] args) {
        //new SpringApplicationBuilder(ApplicationProvider.class).web(true).run(args);
        SpringApplication.run(ApplicationProvider.class,args);
    }
}
