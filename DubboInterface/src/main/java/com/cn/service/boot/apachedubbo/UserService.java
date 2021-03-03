package com.cn.service.boot.apachedubbo;

import com.cn.pojo.UserAddress;

import java.util.List;

public interface UserService {
    List<UserAddress> getUserAddressList(String userId);
}
