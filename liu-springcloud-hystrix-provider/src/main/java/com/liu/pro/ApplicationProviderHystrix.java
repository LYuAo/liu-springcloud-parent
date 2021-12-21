package com.liu.pro;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient  //在服务启动后自动注册到Eureka中
@EnableEurekaClient   //服务发现
@EnableCircuitBreaker   //添加熔断的支持
public class ApplicationProviderHystrix {
    public static void main(String[] args) {
        //new SpringApplicationBuilder(ApplicationProviderHystrix.class).web(true).run(args);
        SpringApplication.run(ApplicationProviderHystrix.class,args);
    }
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet(){
//        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new HystrixMetricsStreamServlet());
//        //访问页面就是监控页面
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        return registrationBean;
//    }


}
