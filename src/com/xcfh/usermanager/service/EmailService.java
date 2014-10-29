package com.xcfh.usermanager.service;

/**
 * Created by zhangfan on 2014/10/27.
 */
public interface EmailService {

    /**
     * 邮箱验证
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    public String emailActivate(String sid, String uidMD5);

    /**
     * 找回密码地址有效性验证
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    public String backPassword(String sid, String uidMD5);

    /**
     * 重置密码
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    public String resetPassword(String sid, String uidMD5, String password);

    /**
     * EmailSession状态验证
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    public String sessionValidate(String sid, String uidMD5);

    /**
     * EmailSession状态修改
     *
     * @param sid
     * @param state
     * @return
     */
    public String alertSessionState(String sid, String state);

    /**
     * 修改用户密码（MD5加密）
     *
     * @param uid
     * @param pw
     * @return
     */
    public String alertPassword(String uid, String pw);

}
