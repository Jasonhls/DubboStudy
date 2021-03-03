package com.cn;

import com.cn.pojo.UserAddress;
import com.cn.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class ConsumerApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = context.getBean(OrderService.class);
        List<UserAddress> userAddresses = orderService.initOrder("1");
        for (UserAddress userAddress : userAddresses) {
            System.out.println(userAddress.toString());
        }
        System.out.println("调用完成。。。");
        System.in.read();
    }
}
