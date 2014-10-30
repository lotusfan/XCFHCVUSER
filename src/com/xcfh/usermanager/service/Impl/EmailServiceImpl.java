package com.xcfh.usermanager.service.Impl;

import com.xcfh.usermanager.dao.EmailDao;
import com.xcfh.usermanager.dao.ManagerDao;
import com.xcfh.usermanager.domain.TbUrlsessEntity;
import com.xcfh.usermanager.domain.TbUserinfoEntity;
import com.xcfh.usermanager.service.EmailService;
import com.xcfh.util.ManagerUtil;
import com.xcfh.util.USERPARAMETER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangfan on 2014/10/27.
 */
@Service("EmailServiceImpl")
public class EmailServiceImpl implements EmailService {
    /**
     * 邮箱激活验证
     * 找回密码地址有效性验证
     * 重置密码
     * EmailSession验证状态返回
     * 修改EmailSession状态
     * 修改密码
     */

    private EmailDao emailDao;
    private ManagerDao managerDao;

    public EmailDao getEmailDao() {
        return emailDao;
    }

    @Resource(name = "EmailDao")
    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    public ManagerDao getManagerDao() {
        return managerDao;
    }

    @Resource(name = "ManagerDao")
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    /**
     * 邮箱激活验证
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    @Override
    public String emailActivate(String sid, String uidMD5) {

        List liste = emailDao.SBySidAndUidMD5(sid, uidMD5);
        if (liste == null || liste.size() == 0) {
            return USERPARAMETER.ACTIVASTATENOEXIST;
        }
        TbUrlsessEntity tbUrlsessEntity = (TbUrlsessEntity) liste.get(0);
        String state = tbUrlsessEntity.getState();
        if (!USERPARAMETER.ACTIVASTATIYES.equals(state)) {//EmailSession是否有效
            return state;
        }
        String uid = tbUrlsessEntity.getUid();
        List listu = managerDao.SByUid(uid);
        if (listu == null || listu.size() == 0) {
            return USERPARAMETER.USERNAMENOEXIST;
        }
        TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) listu.get(0);
        userinfoEntity.setValidateflag(USERPARAMETER.EMAILSTATEYES);//修改用户validateState
        managerDao.alertUser(userinfoEntity);

        tbUrlsessEntity.setState(USERPARAMETER.ACTIVASTATEALERTAL);
        emailDao.alertEmailSession(tbUrlsessEntity);
        return USERPARAMETER.SUCCESS;
    }

    /**
     * 找回密码地址有效性验证
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    @Override
    public String backPassword(String sid, String uidMD5) {
        return emailActivate(sid, uidMD5);
    }

    /**
     * 重置密码
     *
     * @param sid
     * @param uidMD5
     * @param password
     * @return
     */
    @Override
    public String resetPassword(String sid, String uidMD5, String password) {
        List list = emailDao.SBySidAndUidMD5(sid, uidMD5);
        if (list == null || list.size() == 0) {
            return USERPARAMETER.ACTIVASTATENOEXIST;
        }
        TbUrlsessEntity tbUrlsessEntity = (TbUrlsessEntity) list.get(0);
        String uid = tbUrlsessEntity.getUid();
        alertPassword(uid, ManagerUtil.EncryptMD5(password));
        return USERPARAMETER.SUCCESS;
    }


    /**
     * EmailSession验证状态返回
     *
     * @param sid
     * @param uidMD5
     * @return
     */
    @Override
    public String sessionValidate(String sid, String uidMD5) {

        List list = emailDao.SBySidAndUidMD5(sid, uidMD5);

        if (list == null || list.size() == 0) {
            return USERPARAMETER.ACTIVASTATENOEXIST;
        }

        return ((TbUrlsessEntity) list.get(0)).getState();
    }

    /**
     * 修改EmailSession状态
     *
     * @param sid
     * @param state
     * @return
     */
    @Override
    public String alertSessionState(String sid, String state) {
        List list = emailDao.SBySid(sid);
        if (list == null || list.size() == 0) {
            return USERPARAMETER.ACTIVASTATENOEXIST;
        }
        TbUrlsessEntity tbUrlsessEntity = (TbUrlsessEntity) list.get(0);
        tbUrlsessEntity.setState(state);
        emailDao.alertEmailSession(tbUrlsessEntity);
        return USERPARAMETER.SUCCESS;
    }

    /**
     * 修改密码
     *
     * @param uid
     * @param pw
     * @return
     */
    @Override
    public String alertPassword(String uid, String pw) {
        List list = managerDao.SByUid(uid);
        if (list == null || list.size() == 0) {
            return USERPARAMETER.USERNAMENOEXIST;
        }
        TbUserinfoEntity userinfoEntity = (TbUserinfoEntity) list.get(0);
        userinfoEntity.setPword(pw);

        managerDao.alertUser(userinfoEntity);
        return USERPARAMETER.SUCCESS;
    }
}
