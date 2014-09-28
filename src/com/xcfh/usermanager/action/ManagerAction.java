package com.xcfh.usermanager.action;

import com.xcfh.usermanager.service.ManagerService;

import javax.annotation.Resource;

/**
 * Created by xcfh on 2014/9/29.
 * 登录
 * 注册
 * 修改密码
 * 找回密码
 */
public class ManagerAction {
    private ManagerService managerService;

    public ManagerService getManagerService() {
        return managerService;
    }

    @Resource(name = "ManagerServiceProxy")
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    /**
     * 用户登录
     */
    public void userLogin() {

    }

    /**
     * 用户注册
     */
    public void userRegister() {


    }

    /**
     * 修改密码
     */
    public void alertPw() {

    }

    /**
     * 找回密码
     */
    public void backPw() {

    }

}
