package com.atguigu.gmall;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {

    @Test
    public void mainApp() throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");

        ioc.start();

        System.in.read();
    }

    @Test
    public void mainApp1(){
        int a = 1/0;
        System.out.println(a);
    }

}
