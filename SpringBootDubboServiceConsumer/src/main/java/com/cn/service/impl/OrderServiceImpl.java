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

    /**
     * 消费服务，用这个注解，dubbo提供的注解
     * 1.配置loadbalance属性，默认值为random，查看源码LoadBalance的实现类，即知道有几种策略，每种策略的name是什么
     * 2.配置cluster属性，即集群容错配置，查看源码com.alibaba.dubbo.rpc.cluster.Cluster的实现类，默认是failover
     *      failover（默认值）：失败自动切换，当出现失败，重试其他服务器。通常用于读操作，但重试会带来更长延迟。可通过retries="2"来设置重试次数（不含第一次）
     *      failfast：快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
     *      failback：失败自动恢复，后台记录失败请求，定时重新再去请求一次。通常用于消息通知操作。
     *      failsafe：失败安全，出现异常时，直接忽略。通过用于写入审计日志等操作。
     *      forking：并行调用多个服务器，只要一个成功即可。通常用于实时性要求较高的读操作，但需要浪费更多资源。可通过forks="2"来设置最大并行数。
     *      Broadcast：广播
     * 3.配置降级：dubbo提供了mock配置，很好的实现了服务降级处理。
     *      第一种：在远程调用异常时，服务端直接返回一个固定的字符串(也就是写死的字符串)
     *          b比如：
     *          mock="return null"  这种配置不会调用远程服务，直接返回空
     *          mock="fail:return 123"  这种配置会调用远程服务，然后报错
     *      第二种：在远程调用异常时，服务端根据自定义mock业务处理类进行返回)
     *          需要设置mock="true"，然后自定义一个实现UserService的实现了UserServiceMock
     *
     */
//    @Autowired
    @Reference(loadbalance = "roundrobin", timeout = 3000, mock = "true")
//    @Reference(url = "localhost:20880") //采用dubbo直连方式
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId：" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
