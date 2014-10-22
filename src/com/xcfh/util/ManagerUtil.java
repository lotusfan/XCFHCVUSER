package com.xcfh.util;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * Created by xcfh on 2014/10/8.
 * 手机格式验证
 * 邮箱格式验证
 * 日志规范
 * MD5加密
 * 邮件发送
 */
public class ManagerUtil {

    public static final String point = "-";

    /**
     * 邮箱格式验证
     */
    public static boolean EmailFormat(String emailstr) {


        return false;
    }

    /**
     * 手机格式验证
     */
    public static boolean PhoneFormat(String phonestr) {

        return false;
    }

    public static String LogFormat(String packagename, String methodname, String exception, String operationnum) {

        return point + point + point + packagename + point + methodname + point + operationnum + point + point + exception;
    }

    /**
     * MD5加密
     */
    public static String EncryptMD5(String str) {

        String pwd = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            pwd = toSixteen(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toSixteen(pwd.getBytes());
    }

    /**
     * 把密文转换成16进制的字符串形式
     */
    public static String toSixteen(byte[] bytes) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int j = bytes.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = bytes[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];

        }
        return new String(str);
    }

    /**
     * 邮件发送
     */
    public static void sendEmail(String subject, String text, String destationEmail) throws Exception {
        new SendMail().sendMail(destationEmail, subject, text);
    }

    /**
     * 字符串首字母大写
     */
    public static String firstCode(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    /**
     * 生成一个UID
     */
    public static String generateUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

}






















