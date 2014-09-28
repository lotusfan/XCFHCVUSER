package com.xcfh.usermanager.service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by zhangfan on 2014/10/9.
 */
public interface ManagerService {
    /**
     * 用户登录
     */
    public void userLogin(Object  object, OutputStream outputStream);

    /**
     * 本地登录
     */
    public void userLocalLogin();

    /**
     * 三方登录
     */
    public void userThirdLogin();


    /**
     * 用户注册
     */
    public void userRegister(Object  object, OutputStream outputStream);

    /**
     * 手机用户注册
     */
    public void phoneRegister();

    /**
     * 邮箱用户注册
     */
    public void emailRegister();


    /**
     * 修改密码
     */
    public void alertPw(Object  object, OutputStream outputStream);

    /**
     * 找回密码
     */
    public void backPw(Object  object, OutputStream outputStream);
}
