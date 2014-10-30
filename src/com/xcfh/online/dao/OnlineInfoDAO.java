package com.xcfh.online.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@ Repository("OnlineInfoDAO")
public class OnlineInfoDAO {
	private HibernateTemplate hbTemplate;

	public HibernateTemplate getHbTemplate() {

		return hbTemplate;
	}

	@ Resource(name = "HibernateTemplate")
	public void setHbTemplate(HibernateTemplate hbTemplate) {

		this.hbTemplate = hbTemplate;
	}

	public void addOlineInfo(Object o) {

		try {
			hbTemplate.save(o);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
