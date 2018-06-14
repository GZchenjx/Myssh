package com.jx.dao.impl;

import com.jx.bean.Contract;
import com.jx.comment.HibernateUtils;
import com.jx.comment.Pager;
import com.jx.dao.AppSupperDAO;
import com.jx.dao.ContractDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/27.
 */
@Repository
public class ContractDAOImpl extends AppSupperDAO implements ContractDAO{
    @Override
    public void save(Contract contract) {

        getHibernateTemplate().save(contract);
    }

    @Override
    public void remove(Contract contract) {
        getHibernateTemplate().delete(contract);
    }

    @Override
    public void removeById(Long id) {
        Contract contract = new Contract();
        contract.setId(id);
        getHibernateTemplate().delete(id);
    }

    @Override
    public void activice(Long id, Byte status) {

    }

    @Override
    public void update(Contract contract) {
        getHibernateTemplate().update(contract);
    }

    @Override
    public Contract getById(Long id) {
        return getHibernateTemplate().get(Contract.class,id);
    }

    @Override
    public List<Contract> listAll() {
        return getHibernateTemplate().loadAll(Contract.class);
    }

    @Override
    public Pager<Contract> listPager(Pager<Contract> pager) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Contract>>() {
            @Override
            public Pager<Contract> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from Contract");
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
                return (Long) session.createQuery("select count(id) from Contract").uniqueResult();
            }
        });
    }

    @Override
    public Pager<Contract> listPagerCriteria(Pager<Contract> pager, Contract contract) {
        return getHibernateTemplate().execute(new HibernateCallback<Pager<Contract>>() {
            @Override
            public Pager<Contract> doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.pager(session, pager, contract , Contract.class);
            }
        });
    }

    @Override
    public Long countCriteria(Contract contract) {
        return getHibernateTemplate().execute(new HibernateCallback<Long>() {
            @Override
            public Long doInHibernate(Session session) throws HibernateException {
                return HibernateUtils.count(session, contract , null, Contract.class);
            }
        });
    }
}
