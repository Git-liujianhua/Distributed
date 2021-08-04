package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        UserAddress address1 = new UserAddress(1,"浙江省温州市龙湾区文昌路蒲州街道101","1","刘德华","17357782237","Y");
        UserAddress address2 = new UserAddress(2,"山西省大同市灵丘县武灵镇灵源村102","1","刘德华","17357782237","Y");

        return Arrays.asList(address1,address2);

    }
}
