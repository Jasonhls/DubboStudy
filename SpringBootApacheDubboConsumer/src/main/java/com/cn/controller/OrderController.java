package com.cn.controller;

import com.cn.pojo.UserAddress;
import com.cn.service.boot.apachedubbo.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/initOrder")
    public List<UserAddress> initOrder(@RequestParam(value = "uid")String userId) {
        return orderService.initOrder(userId);
    }
}
