package com.xcfh.usermanager.service.Impl;

import com.xcfh.usermanager.dao.ManagerDao;
import com.xcfh.usermanager.domain.TbUrlsessEntity;
import com.xcfh.usermanager.domain.TbUserinfoEntity;
import com.xcfh.usermanager.service.ManagerService;
import com.xcfh.util.Encrypt;
import com.xcfh.util.ManagerUtil;
import com.xcfh.util.USERPARAMETER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.json.*;
import javax.json.spi.JsonProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by xcfh on 2014/9/29.
 * 登录：本地登录,三方登录
 * 注册：手机注册，邮箱注册,三方注册
 * 用户完善、修改信息
 * 修改密码
 * 找回密码：邮箱，手机
 * 邮件发送
 * OutputStream返回
 */
@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    public ManagerDao getManagerDao() {
        return managerDao;
    }

    @Resource(name = "ManagerDao")
    public void setManagerDao(ManagerDao managerDao) {

        this.managerDao = managerDao;
    }

    /**
     * 用户登录
     * json: uname, pword, flag(第三方登录为TH,本地登录为LO)
     */
    public void userLogin(Object object, OutputStream outputStream) {

        JsonObject js = (JsonObject) object;
        System.out.println(js.toString());
        String flag = js.getString("flag");
        String uname = js.getString("uname");
        String pword = js.getString("pword");
        String msg = null;
        String uid = null;

        List list = managerDao.SByNameAndPassword(uname, pword);
        if (list == null || list.size() == 0) {
            if ("LO".equals(flag)) {
                msg = "F";
                uid = "F";
            } else if ("TH".equals(flag)) {
                //三方登录
                uid = thplatRegister(js);
                msg = "T";
            }
        } else if (list.size() == 1) {
            msg = "T";
            uid = ((TbUserinfoEntity) list.get(0)).getUid();
        }

        writeOS(outputStream,
                Json.createObjectBuilder()
                        .add("msg", msg)
                        .add("uid", uid)
                        .build());

    }


    /**
     * 用户注册
     * json: uname, pword
     */
    public void userRegister(Object object, OutputStream outputStream) {

        JsonObject js = (JsonObject) object;
        System.out.println(js.toString());

        String uname = js.getString("uname");
        String msg = null;
        String uid = null;
        String msgnum = null;

        try {
            if (ManagerUtil.EmailFormat(uname) || ManagerUtil.PhoneFormat(uname)) {

                if (proveUname(uname)) {
                    msg = USERPARAMETER.FAIL;
                    msgnum = USERPARAMETER.USERNAMEREPEAT;
                    uid = USERPARAMETER.FAIL;
                    return;
                }

                TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) generateOB(js, TbUserinfoEntity.class);
                userinfoEntity.setUid(ManagerUtil.generateUID());

                if (ManagerUtil.EmailFormat(uname)) {
                    userinfoEntity.setEtEmail(uname);
                    managerDao.addUser(userinfoEntity);
                    sendEmailActivate(uname, uid);
                } else {
                    phoneRegister();
                }
                msg = USERPARAMETER.SUCCESS;
                msgnum = USERPARAMETER.SUCCESS;
                uid = userinfoEntity.getUid();

            } else {
                msg = USERPARAMETER.FAIL;
                uid = USERPARAMETER.FAIL;
                msgnum = USERPARAMETER.USERNAMENOFORMAT;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            writeOS(outputStream,
                    Json.createObjectBuilder()
                            .add("msg", msg)
                            .add("uid", uid)
                            .add("msgnum", msgnum)
                            .build());
        }


    }

    /**
     * 手机用户注册
     */
    public void phoneRegister() {

    }

    /**
     * 邮箱用户注册
     */
    public void emailRegister(String uname, String uid) {


    }

    /**
     * 三方用户注册
     */
    public String thplatRegister(JsonObject jsonObject) {

        String uid;
        TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) generateOB(jsonObject, TbUserinfoEntity.class);
        userinfoEntity.setUid(uid = ManagerUtil.generateUID());
        managerDao.addUser(userinfoEntity);
        return uid;
    }

    /**
     * 用户信息完善、修改
     *
     * @param object
     * @param outputStream json:全量
     */
    @Override
    public void userConsummate(Object object, OutputStream outputStream) {
        JsonObject jsonObject = (JsonObject) object;
        String msg = null;
        String msgnum = null;
        String uid = jsonObject.getString("uid");
        try {
            List list = managerDao.SByUid(uid);
            if (list == null || list.size() == 0) {
                msg = USERPARAMETER.FAIL;
                msgnum = USERPARAMETER.UIDNOEXIST;
                return;
            }
            TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) list.get(0);
            userinfoEntity = (TbUserinfoEntity) generateOB(jsonObject, userinfoEntity.getClass());
            managerDao.addUser(userinfoEntity);
            msg = USERPARAMETER.SUCCESS;
            msgnum = USERPARAMETER.SUCCESS;

        } catch (Exception e) {
            msg = USERPARAMETER.FAIL;
            msgnum = USERPARAMETER.FAIL;
            System.out.println(e.toString());
        } finally {
            writeOS(outputStream,
                    Json.createObjectBuilder()
                            .add("msg", msg)
                            .add("msgnum", msgnum)
                            .build());
        }
    }

    /**
     * 验证用户是否重复
     * 重复true, 不重复false
     */
    public boolean proveUname(String uname) {
        boolean flag = false;
        List list = managerDao.SByUname(uname);
        if (list != null && list.size() > 0) flag = true;
        return flag;
    }


    /**
     * 修改密码
     * json: uid, pword, uname
     */
    public void alertPw(Object object, OutputStream outputStream) {

        JsonObject jsonObject = (JsonObject) object;
        String msg = null;
        String msgnum = null;

        try {
            List list = managerDao.SByUidAndPassword(jsonObject.getString("uid"), jsonObject.getString("pword"));
            if (list == null || list.size() == 0) {
                msg = USERPARAMETER.FAIL;
                msgnum = USERPARAMETER.OLDPAWWORDERROR;
                return;
            }
            TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) list.get(0);
            userinfoEntity = (TbUserinfoEntity) generateOB(jsonObject, userinfoEntity.getClass());
            managerDao.alertUser(userinfoEntity);
            msg = USERPARAMETER.SUCCESS;
            msgnum = USERPARAMETER.SUCCESS;
        } catch (Exception e) {
            msg = USERPARAMETER.FAIL;
            msgnum = USERPARAMETER.FAIL;
            System.out.println(e.getMessage());
        } finally {
            writeOS(outputStream,
                    Json.createObjectBuilder()
                            .add("msg", msg)
                            .add("msgnum", msgnum)
                            .build());
        }


    }

    /**
     * 找回密码
     * json:uname
     */
    public void backPw(Object object, OutputStream outputStream) {
        JsonObject jsonObject = (JsonObject) object;
        String uname = jsonObject.getString("uname");
        String msg = USERPARAMETER.FAIL;
        String msgnum = USERPARAMETER.FAIL;
        try {
            List list = managerDao.SByUname(uname);
            if (list == null || list.size() == 0) {
                msgnum = USERPARAMETER.USERNAMENOEXIST;
                return;
            }
            TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) list.get(0);
            sendEmailBack(userinfoEntity.getEtEmail(), userinfoEntity.getUid());
            msg = USERPARAMETER.SUCCESS;
            msg = USERPARAMETER.SUCCESS;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            writeOS(outputStream,
                    Json.createObjectBuilder()
                            .add("msg", msg)
                            .add("msgnum", msgnum)
                            .build());
        }


    }

    /**
     * 邮箱注册激活邮箱的邮件发送
     */
    public void sendEmailActivate(String desEmail, String uid) throws Exception {

        JsonObject jsonObject = addURLSession(uid);
        String uidMD5 = jsonObject.getString("uidMD5");
        String sid = jsonObject.getString("sid");
        String text = "http://www.xcfh?" +
                "uid=" + uidMD5 +
                "sid=" + sid; //内容
        String subject = "激活邮箱验证";//主题
        ManagerUtil.sendEmail(subject, text, desEmail);

    }

    /**
     * 使用邮箱找回密码的邮件发送
     */
    public void sendEmailBack(String desEmail, String uid) throws Exception {

        JsonObject jsonObject = addURLSession(uid);
        String uidMD5 = jsonObject.getString("uidMD5");
        String sid = jsonObject.getString("sid");
        String text = "http://www.xcfh?" +
                "uid=" + uidMD5 +
                "sid=" + sid; //内容
        String subject = "邮箱找回密码";//主题
        ManagerUtil.sendEmail(subject, text, desEmail);
    }

    /**
     * OutputStream返回
     */
    public void writeOS(OutputStream outputStream, JsonObject jsonObject) {

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jsonObject.toString().getBytes());
            outputStream.write(Encrypt.ensecret(byteArrayInputStream));
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

    public Object generateOB(JsonObject jsonObject, Class comclass) {

        try {
            Set jsonset = jsonObject.keySet();
            Iterator iterator = jsonset.iterator();
            String key;
            Object o = comclass.newInstance();
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                Method method = comclass.getMethod("set" + ManagerUtil.firstCode(key));
                method.invoke(o, jsonObject.getString(key));
            }
            return o;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public JsonObject addURLSession(String uid) {

        String sid = ManagerUtil.generateUID();
        String uidMD5 = ManagerUtil.EncryptMD5(uid);
        String msg = USERPARAMETER.SUCCESS;
        try {
            TbUrlsessEntity tbUrlsessEntity = new TbUrlsessEntity();
            tbUrlsessEntity.setSid(sid);
            tbUrlsessEntity.setUid(uid);
            tbUrlsessEntity.setUidMd5(uidMD5);
            tbUrlsessEntity.setTimeMs(System.currentTimeMillis() + "");
            tbUrlsessEntity.setState(USERPARAMETER.ACTIVASTATENO);
            managerDao.addURLSession(tbUrlsessEntity);
        } catch (Exception e) {
            msg = USERPARAMETER.FAIL;
            System.out.println(e.toString());
        }
        return Json.createObjectBuilder()
                .add("sid", sid)
                .add("udiMD5", uidMD5)
                .add("msg", msg)
                .build();

    }

}

