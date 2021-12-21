package com.liu.fei.cun;

import com.liu.fei.config.LiuIRuleConfig;
import com.liu.fei.config.LiuRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


//Ribbon 和 Eureka整合以后,客户端可以直接调用,不要关心IP地址
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.bdqn"})
@ComponentScan({"com.liu.fei","com.bdqn.service"}) //在服务消费者的启动类中是否将FallbackFactory实现类扫描进IOC容器
//@RibbonClient(name="PROVIDER",configuration = LiuIRuleConfig.class)
public class ApplicationConsumerFeign {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsumerFeign.class,args);
    }
}
