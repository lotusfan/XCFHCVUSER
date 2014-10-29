package com.xcfh.usermanager.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.xcfh.usermanager.service.EmailService;
import com.xcfh.util.USERPARAMETER;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by xcfh on 2014/9/29.
 * 邮箱注册后激活
 * 邮箱找回密码
 * 提交重置密码
 */
@Namespace("email")
public class EmailAtion extends ActionSupport {

    private String sid;
    private String uidMD5;
    private String reason;
    private EmailService emailService;
    private String password;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUidMD5() {
        return uidMD5;
    }

    public void setUidMD5(String uidMD5) {
        this.uidMD5 = uidMD5;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 邮箱注册后激活
     *
     * @return
     */
    @org.apache.struts2.convention.annotation.Action(value = "eactivate",
            results = {
                    @Result(location = "/jpg/激活成功.png"),
                    @Result(name = "input", location = "/jpg/激活失败.png")
            }
    )
    public String emailActivate() {

        String str = emailService.emailActivate(sid, uidMD5);
        if (USERPARAMETER.SUCCESS.equals(str)) {
            return Action.SUCCESS;
        }
        reason = USERPARAMETER.JSON_OBJECT.getString(str);
        return Action.INPUT;
    }

    /**
     * 邮箱找回密码验证地址是否有效
     *
     * @return
     */
    @org.apache.struts2.convention.annotation.Action(value = "bpassword",
            results = {
                    @Result(location = "/jpg/重置密码.png"),
                    @Result(name = "input", location = "/jpg/验证失败.png")
            }
    )
    public String backPassword() {

        String str = emailService.backPassword(sid, uidMD5);
        if (USERPARAMETER.SUCCESS.equals(str)) {
            return Action.SUCCESS;
        }
        reason = USERPARAMETER.JSON_OBJECT.getString(str);
        return Action.INPUT;
    }

    /**
     * 重置密码
     *
     * @return
     */
    @org.apache.struts2.convention.annotation.Action(value = "rpassword",
            results = {
                    @Result(location = "/jpg/重置密码成功.png"),
                    @Result(name = "input", location = "/jpg/重置密码失败.png")
            }
    )
    public String resetPassword() {

        String str = emailService.resetPassword(sid, uidMD5, password);
        if (USERPARAMETER.SUCCESS.equals(str)) {
            return Action.SUCCESS;
        }
        reason = USERPARAMETER.JSON_OBJECT.getString(str);
        return Action.INPUT;
    }
}
