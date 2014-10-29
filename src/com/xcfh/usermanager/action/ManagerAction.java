package com.xcfh.usermanager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xcfh.usermanager.service.ManagerService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import javax.annotation.Resource;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by xcfh on 2014/9/29.
 * 登录
 * 注册
 * 修改密码
 * 找回密码
 */
@Namespace("/")
public class ManagerAction extends ActionSupport {
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
    @Action(value = "userlogin")
    public void userLogin() {

        try {
            InputStream in = ServletActionContext.getRequest().getInputStream();
            OutputStream out = ServletActionContext.getResponse().getOutputStream();
            managerService.userLogin(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户注册
     */
    @Action(value = "userregister")
    public void userRegister() {

        try {
            InputStream in = ServletActionContext.getRequest().getInputStream();
            OutputStream out = ServletActionContext.getResponse().getOutputStream();
            managerService.userRegister(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改密码
     */
    @Action(value = "alertpw")
    public void alertPw() {

        try {
            InputStream in = ServletActionContext.getRequest().getInputStream();
            OutputStream out = ServletActionContext.getResponse().getOutputStream();
            managerService.alertPw(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 找回密码
     */
    @Action(value = "backpw")
    public void backPw() {
        try {
            InputStream in = ServletActionContext.getRequest().getInputStream();
            OutputStream out = ServletActionContext.getResponse().getOutputStream();
            managerService.backPw(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
