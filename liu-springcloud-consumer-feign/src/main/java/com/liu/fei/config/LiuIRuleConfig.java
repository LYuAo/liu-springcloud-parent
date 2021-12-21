package com.liu.fei.config;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiuIRuleConfig   {
    //AbstractLoadBalancerRule
    //RoundRobinRule 轮询
    //RandomRule  随机
    //WeightedResponseTimeRule  权重
    //AvailabilityFilteringRule: 会先过滤跳闸,访问故障的服务,对剩下的进行轮询
    //RetryRule   会先按轮询获取服务，如果获取服务失败就会在指定的时间内进行,重试
    @Bean
    public IRule iRule(){
        return new LiuRandomRule();
    }

}
