package com.cn.service.impl;

import com.cn.pojo.UserAddress;
import com.cn.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @description: dubbo的本地存根，会被先调用，然后再去调用远程服务
 * @author: helisen
 * @create: 2021-03-05 10:07
 **/
public class UserServiceStub implements UserService {

    private final UserService userService;

    /**
     * 传入的是UserService的远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("调用了本地存根。。。");
        if(!StringUtils.isEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
