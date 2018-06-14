package com.jx.dao.impl;

import com.jx.bean.Clazz;
import com.jx.comment.HibernateUtils;
import com.jx.comment.Pager;
import com.jx.dao.AppSupperDAO;
import com.jx.dao.ClazzDAO;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by CHEN JX on 2017/11/21.
 */
@Repository
public class ClazzDAOImpl extends AppSupperDAO implements ClazzDAO{
    @Override
    public void save(Clazz clazz) {
        getHibernateTemplate().save(clazz);
    }

    @Override
    public void remove(Clazz clazz) {
        getHibernateTemplate().delete(clazz);

    }

    @Override
    public void removeById(Long id) {
        Clazz clazz = new Clazz();
        clazz.setId(id);
        getHibernateTemplate().delete(clazz);
    }

    @Override
    public void activice(Long id, Byte status) {

    }

    @Override
    public void update(Clazz clazz) {
        getHibernateTemplate().update(clazz);
    }

    @Override
    public Clazz getById(Long id) {
      /*  Session session = getSessionFactory().openSession();
        return session.get(Clazz.class, id);*/
      return getHibernateTemplate().get(Clazz.class,id);
    }

    @Override
    public List<Clazz> listAll() {
        return getHibernateTemplate().loadAll(Clazz.class);
    }

    @Override
    public Pager<Clazz> listPager(Pager<Clazz> pager) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Clazz>>() {
            @Override
            public Pager<Clazz> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from Clazz");
                query.setFirstResult(pager.getBeginIndex());
                query.setMaxResults(pager.getPageSize());
                pager.setRows(query.list());
                return pager;
            }
        });
    }

    @Override
    public Long count() {
       return getHibernateTemplate().execute(new HibernateCallback<Long>() {
           @Override
           public Long doInHibernate(Session session) throws HibernateException {
               return (Long) session.createQuery("select count (id) from Clazz").uniqueResult();
           }
       });
    }
    @Override
    public Pager<Clazz> listPagerCriteria(Pager<Clazz> pager, Clazz clazz) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Clazz>>() {
            @Override
            public Pager<Clazz> doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.pager(session, pager, clazz, Clazz.class);
            }
        });
    }


    @Override
    public Long countCriteria(Clazz clazz) {
        return getHibernateTemplate().execute(new HibernateCallback<Long>() {
            @Override
            public Long doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.count(session,clazz,null,Clazz.class);
            }
        });
    }


}
