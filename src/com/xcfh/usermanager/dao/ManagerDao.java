package com.xcfh.usermanager.dao;

import com.xcfh.usermanager.domain.TbUserinfoEntity;

/**
 * Created by zhangfan on 2014/10/13.
 */
public class ManagerDao {

    /**
     * 用户信息添加
     * 用户信息修改
     * 用户信息查询（条件：用户名（手机号或邮箱）， 密码。）
     * 用户信息查询（条件：用户ID）
     * 密码重置
     */
    public void addUser(TbUserinfoEntity user) {

    }

    public void alertUser(TbUserinfoEntity userinfoEntity) {

    }

    public void SByNameAndPassword(String name, String password) {

    }

    public void SByUid(String uid) {

    }

    public void alertPassword(String uid, String password) {

    }
}
