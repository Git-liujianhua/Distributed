package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 *      1）导入dubbo依赖（2.6.10）、操作zookeeper的客户端（curator）
 *      2）配置服务提供者
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private UserService userService;

    @Override
    public void initOrder(String userId) {
        System.out.println("获取ID为："+ userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress address : userAddressList) {
            System.out.println(address.getUserAddress());
        }
    }
}
