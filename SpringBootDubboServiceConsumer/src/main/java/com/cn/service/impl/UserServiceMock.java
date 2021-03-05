package com.cn.service.impl;

import com.cn.pojo.UserAddress;
import com.cn.service.boot.alibabadubbo.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-05 16:18
 **/
@Service
public class UserServiceMock implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("走了这里了。。。");
        return new ArrayList<>();
    }
}
