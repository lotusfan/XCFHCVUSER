package com.xcfh.usermanager.service;

/**
 * Created by zhangfan on 2014/10/9.
 */
public class TestService implements TestServiceIn{
    public void login(String name, int age) {
        System.out.println("正在登录！----");
        System.out.println("name=" + name + "age=" + age);
        System.out.println("登录成功");
    }
}
