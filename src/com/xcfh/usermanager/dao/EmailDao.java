package com.xcfh.usermanager.dao;

import com.xcfh.usermanager.domain.TbUrlsessEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangfan on 2014/10/28.
 */
@Repository("EmailDao")
public class EmailDao {
    /**
     * 查询EmailSession：条件sid, uidMD5
     * 修改EmailSesison状态
     */
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public List SBySidAndUidMD5(String sid, String uidMD5) {

        List list = null;
        try {
            String hql = "from TbUrlsessEntity where sid=:sid and uidMd5=:uidMD5";
            Session session = hibernateTemplate.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            query.setString("sid", sid);
            query.setString("uidMD5", uidMD5);
            list = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List SBySid(String sid) {
        List list = null;
        try {
            String hql = "from TbUrlsessEntity where sid=:sid";
            Session session = hibernateTemplate.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            query.setString("sid", sid);
            list = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 修改EmailSession状态
     *
     * @param tbUrlsessEntity
     */
    public void alertEmailSession(TbUrlsessEntity tbUrlsessEntity) {

        try {
            hibernateTemplate.update(tbUrlsessEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
