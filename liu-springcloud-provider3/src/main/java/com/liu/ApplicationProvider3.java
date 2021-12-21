package com.liu;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class ApplicationProvider3 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider3.class,args);
    }
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet(){
//        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new HystrixMetricsStreamServlet());
//        //访问页面就是监控页面
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        return registrationBean;
//    }
}
