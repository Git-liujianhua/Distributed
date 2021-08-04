package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;

import java.util.List;

public class UserServiceStub implements UserService{

    private final UserService userService;

    /**
     * 传入userService远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        if (userId != ""){
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
