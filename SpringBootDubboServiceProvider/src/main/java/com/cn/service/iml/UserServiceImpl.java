package com.cn.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.cn.pojo.UserAddress;
import com.cn.service.boot.alibabadubbo.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 */
@Service//暴露服务，用这个注解，dubbo自带的
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层","1", "李老师", "010-12477555", "Y");
        UserAddress userAddress2 = new UserAddress(1, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）","2", "王老师", "0755-89587458", "N");
        return Arrays.asList(userAddress1, userAddress2);
    }
}
