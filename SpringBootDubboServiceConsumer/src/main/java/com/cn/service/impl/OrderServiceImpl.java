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

//    @Autowired
    @Reference//消费服务，用这个注解，dubbo提供的注解
//    @Reference(url = "localhost:20880") //采用dubbo直连方式
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId：" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
