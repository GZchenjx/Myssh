package com.jx.dao.impl;

import com.jx.bean.Teacher;
import com.jx.comment.HibernateUtils;
import com.jx.comment.Pager;
import com.jx.dao.AppSupperDAO;
import com.jx.dao.TeacherDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/27.
 */
@Repository
public class TeacherDAOImpl extends AppSupperDAO implements TeacherDAO{
    @Override
    public void save(Teacher teacher) {
        getHibernateTemplate().save(teacher);
    }

    @Override
    public void remove(Teacher teacher) {
        getHibernateTemplate().delete(teacher);
    }

    @Override
    public void removeById(Long id) {
        Teacher teacher = new Teacher();
        getHibernateTemplate().delete(id);
    }

    @Override
    public void activice(Long id, Byte status) {

    }

    @Override
    public void update(Teacher teacher) {
        getHibernateTemplate().update(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return getHibernateTemplate().get(Teacher.class,id);
    }

    @Override
    public List<Teacher> listAll() {
        return getHibernateTemplate().loadAll(Teacher.class);
    }

    @Override
    public Pager<Teacher> listPager(Pager<Teacher> pager) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Teacher>>() {
            @Override
            public Pager<Teacher> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from Teacher");
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
                return (Long) session.createQuery("select count(id) from Teacher").uniqueResult();
            }
        });
    }

    @Override
    public Pager<Teacher> listPagerCriteria(Pager<Teacher> pager, Teacher teacher) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Teacher>>() {
            @Override
            public Pager<Teacher> doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.pager(session,pager,teacher,Teacher.class);
            }
        });
    }

    @Override
    public Pager<Teacher> listPagerCriteria1(Pager<Teacher> pager, Teacher teacher) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Teacher>>() {
            @Override
            public Pager<Teacher> doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.pager(session,pager,teacher,Teacher.class);
            }
        });
    }

    @Override
    public Long countCriteria(Teacher teacher) {
        return getHibernateTemplate().execute(new HibernateCallback<Long>() {
            @Override
            public Long doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.count(session,teacher,null,Teacher.class);
            }
        });
    }

    @Override
    public void save(Long teacherId, List<Long> clazzsId) {
        getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createNativeQuery("insert into t_class_teacher(class_id, teacher_id) values(:classId, :teacherId)");
                for (Long classId : clazzsId) {
                    query.setParameter("classId", classId);
                    query.setParameter("teacherId", teacherId);
                    query.executeUpdate();
                }
                return null;
            }
        });
    }

}
