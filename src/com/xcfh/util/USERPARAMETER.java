package com.xcfh.util;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Created by zhangfan on 2014/10/21.
 */
public class USERPARAMETER {
    public static final String USERNAMEREPEAT = "0001";//用户名重复
    public static final String USERNAMENOFORMAT = "0002";//用户名格式错误
    public static final String USERNAMENOEXIST = "0003";//用户名不存在
    public static final String SUCCESS = "success";//成功
    public static final String FAIL = "fail";//失败
    public static final String DBADDERROR = "0004";//插入数据库错误
    public static final String UIDNOEXIST = "0005";//UID不存在
    public static final String OLDPAWWORDERROR = "0006";//旧密码输入错误

    //邮件Session状态码
    public static final String ACTIVASTATENOEXIST = "1001";//不存在状态
    public static final String ACTIVASTATIYES = "1002";//存在状态
    public static final String ACTIVASTATETIMEOUT = "1003";//超时
    public static final String ACTIVASTATEALERTAL = "1004";//已经修改
    public static final String ACTIVASTATVALIDATE = "1005";//已经验证

    //用户手机邮箱激活
    public static final String VALIDATESTATENO = "2001";//未验证状态
    public static final String EMAILSTATEYES = "2002";//邮箱验证状态
    //手机验证状态
    //手机邮箱都验证状态
    public static JsonObject JSON_OBJECT = Json.createObjectBuilder()
            .add(USERNAMEREPEAT, "用户名重复")
            .add(USERNAMENOFORMAT, "用户名格式错误")
            .add(USERNAMENOEXIST, "用户名不存在")
            .add(SUCCESS, "成功")
            .add(FAIL, "失败")
            .add(DBADDERROR, "插入数据库错误")
            .add(UIDNOEXIST, "UID不存在")
            .add(OLDPAWWORDERROR, "旧密码输入错误")
            .add(ACTIVASTATENOEXIST, "不存在状态")
            .add(ACTIVASTATIYES, "")
            .add(ACTIVASTATETIMEOUT, "")
            .add(ACTIVASTATEALERTAL, "")
            .add(ACTIVASTATVALIDATE, "")
            .add(VALIDATESTATENO, "")
            .add(EMAILSTATEYES, "")
            .build();
}
