package com.xcfh.usermanager.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;

/**
 * Created by zhangfan on 2014/10/13.
 */
public class HibernateSession {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name="HibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
