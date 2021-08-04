package com.atguigu.gmall;

import com.atguigu.gmall.service.OrderService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {

    @Test
    public void mainTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService bean = context.getBean(OrderService.class);

        bean.initOrder("1");

        System.out.println("调用结束.....");

        System.in.read();
    }
}
