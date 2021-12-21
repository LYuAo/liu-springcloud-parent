package com.liu.cun;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemp {

    @Bean
    @LoadBalanced  //配置负载均衡实现RestTemplate
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
