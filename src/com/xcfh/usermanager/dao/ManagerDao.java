package com.xcfh.usermanager.dao;

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
     * 密码重置
     */
    public void addUser(TbUserinfoEntity user) {
        try {
            hibernateTemplate.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void alertUser(TbUserinfoEntity userinfoEntity) {

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

    public List SByUname(String unmae) {
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

    public void alertPassword(String uid, String password) {

    }

    public List SByUidAndPassword(String uid, String password) {

        return null;
    }
}
