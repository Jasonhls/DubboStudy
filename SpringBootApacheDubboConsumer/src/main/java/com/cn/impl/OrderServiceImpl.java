package com.cn.impl;

import com.cn.pojo.UserAddress;
import com.cn.service.boot.apachedubbo.OrderService;
import com.cn.service.boot.apachedubbo.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
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

//    @Autowired
    @DubboReference//消费服务，用这个注解，dubbo提供的注解
        UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId：" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
