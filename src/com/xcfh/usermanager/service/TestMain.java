package com.xcfh.usermanager.service;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangfan on 2014/10/9.
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/spring-config.xml");
//        TestServiceIn testService = (TestServiceIn) applicationContext.getBean("userlogin");
//        testService.login("zhangfan", 23);

//        ManagerService managerService = (ManagerService) applicationContext.getBean("ManagerServiceProxy");
//        InputStream inputStream = new FileInputStream(new File("D://csdnsecretdes.txt"));
//        managerService.userLogin(inputStream, null);

//        HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("HibernateTemplate");
//        SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
        SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
        System.out.println(sessionFactory.openSession());
        System.out.println(sessionFactory.getCurrentSession());

    }
}