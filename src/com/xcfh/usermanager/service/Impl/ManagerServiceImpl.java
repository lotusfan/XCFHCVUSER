package com.xcfh.usermanager.service.Impl;

import com.xcfh.usermanager.service.ManagerService;
import com.xcfh.util.Encrypt;
import com.xcfh.util.ManagerUtil;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

/**
 * Created by xcfh on 2014/9/29.
 * 登录：本地登录,三方登录
 * 注册：手机注册，邮箱注册,三方注册
 * 修改密码
 * 找回密码：邮箱，手机
 * 邮件发送
 * OutputStream返回
 */
@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements ManagerService {
    /**
     * 用户登录
     */
    public void userLogin(Object object, OutputStream outputStream) {

        JsonObject js = (JsonObject) object;
        System.out.println(js.toString());

    }

    /**
     * 本地登录
     */
    public void userLocalLogin() {

    }

    /**
     * 三方登录
     */
    public void userThirdLogin() {

    }


    /**
     * 用户注册
     */
    public void userRegister(Object object, OutputStream outputStream) {

    }

    /**
     * 手机用户注册
     */
    public void phoneRegister() {

    }

    /**
     * 邮箱用户注册
     */
    public void emailRegister() {

    }


    /**
     * 修改密码
     */
    public void alertPw(Object object, OutputStream outputStream) {

    }

    /**
     * 找回密码
     */
    public void backPw(Object object, OutputStream outputStream) {

    }

    /**
     * 邮箱注册激活邮箱的邮件发送
     */
    public void sendEmailActivate(String desEmail, String uid) throws Exception {

        String text = ""; //内容
        String subject = "";//主题
        ManagerUtil.sendEmail(subject, text, desEmail);
    }

    /**
     * 使用邮箱找回密码的邮件发送
     */
    public void sendEmailBack(String desEmail, String uid) throws Exception {

        String text = ""; //内容
        String subject = "";//主题
        ManagerUtil.sendEmail(subject, text, desEmail);
    }

    /**
     * OutputStream返回
     */
    public void wirteOS(OutputStream outputStream, byte[] content) {

        try {

            outputStream.write(content);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) outputStream.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }


}

