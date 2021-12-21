package com.liu.cun;

import com.liu.config.LiuIRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


//Ribbon 和 Eureka整合以后,客户端可以直接调用,不要关心IP地址
@SpringBootApplication
@EnableEurekaClient
//在服务启动的时候加载自定义的Ribbon类
@RibbonClient(name = "PROVIDER",configuration = LiuIRuleConfig.class)
public class ApplicationConsunmer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsunmer.class,args);
    }
}
