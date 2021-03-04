package com.cn.service.impl;

import com.cn.pojo.UserAddress;
import com.cn.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-04 17:06
 **/
public class UserServiceImpl2 implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("调用了服务提供方的getUserAddressList方法。。。版本02");
        UserAddress userAddress1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层","1", "李老师", "010-12477555", "Y");
        UserAddress userAddress2 = new UserAddress(1, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）","2", "王老师", "0755-89587458", "N");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(userAddress1, userAddress2);
    }
}
