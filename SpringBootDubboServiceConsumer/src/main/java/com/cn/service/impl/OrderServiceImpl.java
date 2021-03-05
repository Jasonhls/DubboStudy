package com.cn.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cn.pojo.UserAddress;
import com.cn.service.boot.alibabadubbo.OrderService;
import com.cn.service.boot.alibabadubbo.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1.将服务提供者注册到注册中心（暴露服务）
 *     1)、导入dubbo依赖（2.6.2），操作zookeeper客户端（curator）
 * 2.让服务消费者去注册中心订阅服务提供者的服务地址
 * @author admin
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 消费服务，用这个注解，dubbo提供的注解
     * 配置loadbalance属性，默认值为random，查看源码LoadBalance的实现类，即知道有几种策略，每种策略的name是什么
     * 配置cluster属性，即集群容错配置，查看源码com.alibaba.dubbo.rpc.cluster.Cluster的实现类，默认是failover
     * failover（默认值）：会去调用远程服务，如果失败，会重试两次，不知道为啥是两次？
     * failfast：会去调用远程服务，如果失败，直接报错，不会进行重试
     * failback：会去调用远程服务，如果失败，就返回为null，会进行重试，默认执行一次。
     * failsafe：会去调用远程服务，如果失败，就返回null，不会执行默认的重试一次。
     *
     */
//    @Autowired
    @Reference(loadbalance = "roundrobin", timeout = 3000)
//    @Reference(url = "localhost:20880") //采用dubbo直连方式
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId：" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
