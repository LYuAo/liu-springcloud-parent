
package com.liu.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class LiuRandomRule extends AbstractLoadBalancerRule {
    private int index=0;   //当前谁提供服务
    private int total=0;   //被提供次数
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {  //线程中断
                return null;
            }
            List<Server> upList = lb.getReachableServers();   //获取可以用的服务
            List<Server> allList = lb.getAllServers();     //获得全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

//            int index = chooseRandomInt(serverCount);   //生成随机数
//            server = upList.get(index);    //从活着的服务中随机获取一个
            if(total<3){
               server=upList.get(index);
               total++;
            }else {
               total=0;
               index++;
               if(index==upList.size()){
                   index=0;
               }
               server=upList.get(index);  //从活着的服务中,获取指定服务来操作
            }
            if (server == null) {
                Thread.yield();   //线程礼让
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            // 真的不应该发生。 但一定是暂时的或者有bug  .
            server = null;
            Thread.yield();   //线程礼让
        }

        return server;

    }
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
