package com.xcfh.usermanager.dao;

import com.xcfh.usermanager.domain.TbUrlsessEntity;
import com.xcfh.usermanager.domain.TbUserinfoEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangfan on 2014/10/13.
 */
@Repository("ManagerDao")
public class ManagerDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "HibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 用户信息添加
     * 用户信息修改
     * 用户信息查询（条件：用户名（手机号或邮箱）， 密码。）
     * 用户信息查询（条件：用户ID）
     * 用户信息查询（用户名）
     * 用户信息查询（用户ID，密码）
     * 密码重置
     * URLSession信息添加
     * URLSession信息修改
     */
    public void addUser(TbUserinfoEntity user) {
        try {
            hibernateTemplate.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void alertUser(TbUserinfoEntity userinfoEntity) {

        try {
            hibernateTemplate.update(userinfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List SByNameAndPassword(String name, String password) {

        List list = null;
        try {
            String hql = "";
            Session session = hibernateTemplate.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            list = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List SByUid(String uid) {

        return null;
    }

    public List SByUname(String uname) {
        List list = null;
        try {
            String hql = "from TbUserinfoEntity where uname=:uname";
            Session session = hibernateTemplate.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            query.setString("uname", uname);
            list = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void alertPassword(String uid, String password) {

    }

    public List SByUidAndPassword(String uid, String password) {

        List list = null;
        try {
            String hql = "from TbUserinfoEntity where uid=:uid and pword =:pword";
            Session session = hibernateTemplate.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            query.setString("uid", uid);
            query.setString("pword", password);
            list = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public void addURLSession(TbUrlsessEntity tbUrlsessEntity) {

        try {
            hibernateTemplate.save(tbUrlsessEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alertURLSession(TbUrlsessEntity tbUrlsessEntity) {

        try {
            hibernateTemplate.update(tbUrlsessEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
