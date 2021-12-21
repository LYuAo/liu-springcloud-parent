package com.liu.fei.cun;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemp {
    @LoadBalanced  //配置负载均衡实现RestTemplate
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
