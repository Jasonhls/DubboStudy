package com.cn.service.impl;

import com.cn.pojo.UserAddress;
import com.cn.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层","1", "李老师", "010-12477555", "Y");
        UserAddress userAddress2 = new UserAddress(1, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）","2", "王老师", "0755-89587458", "N");
        return Arrays.asList(userAddress1, userAddress2);
    }
}
