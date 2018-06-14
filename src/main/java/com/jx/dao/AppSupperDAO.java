package com.jx.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;

/**
 * Created by CHEN JX on 2017/11/22.
 */
public class AppSupperDAO extends HibernateDaoSupport {

    @Resource(name="sessionFactory")
    public void setSessionFaction(SessionFactory sessionFaction) {
        super.setSessionFactory(sessionFaction);
    }
}
