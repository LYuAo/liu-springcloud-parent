package com.liu.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient  //在服务启动后自动注册到Eureka中
@EnableEurekaClient   //服务发现
@EnableCircuitBreaker   //添加熔断的支持
public class ApplicationProviderHystrix2 {
    public static void main(String[] args) {
        //new SpringApplicationBuilder(ApplicationProviderHystrix2.class).web(true).run(args);
        SpringApplication.run(ApplicationProviderHystrix2.class,args);
    }
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet(){
//        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new HystrixMetricsStreamServlet());
//        //访问页面就是监控页面
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        return registrationBean;
//    }


}
