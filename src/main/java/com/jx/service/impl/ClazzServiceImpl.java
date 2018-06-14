package com.jx.service.impl;

import com.jx.bean.Clazz;
import com.jx.comment.Pager;
import com.jx.dao.ClazzDAO;
import com.jx.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/22.
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDAO clazzDAO;
    @Override
    public void save(Clazz clazz) {
        clazzDAO.save(clazz);
    }

    @Override
    public void remove(Clazz clazz) {
        clazzDAO.remove(clazz);
    }

    @Override
    public void removeById(Long id) {
        clazzDAO.removeById(id);

    }

    @Override
    public void active(Long id, Byte status) {

    }

    @Override
    public void update(Clazz clazz) {
        clazzDAO.update(clazz);
    }

    @Override
    public Clazz getById(Long id) {
        return clazzDAO.getById(id);
    }

    @Override
    public List<Clazz> listAll() {
        return clazzDAO.listAll();
    }

    @Override
    public Pager<Clazz> listPager(int pageNo, int pageSize) {
        Pager<Clazz> clazzPager = new Pager<>(pageNo,pageSize);
        clazzPager = clazzDAO.listPager(clazzPager);
        clazzPager.setTotal(clazzDAO.count());
        return clazzPager;
    }


    @Override
    public Pager<Clazz> listPagerCriteria(int pageNo, int pageSize, Clazz clazz) {
        Pager<Clazz> pager = new Pager<>(pageNo, pageSize);
        pager.setTotal(clazzDAO.countCriteria(clazz));
        return clazzDAO.listPagerCriteria(pager, clazz);
    }
}
