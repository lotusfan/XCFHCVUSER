package com.xcfh.usermanager.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zhangfan on 2014/10/9.
 */
public class TestServiceAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        System.out.println("登录前检测--");
        System.out.println("Method=" + method.getName() + "username=" + (String) objects[0] + "age=" + (Integer) objects[1]);
        System.out.println("完成检测---");
        objects[0] = "lotusfan";

    }
}
