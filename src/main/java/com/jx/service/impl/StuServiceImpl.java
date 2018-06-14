package com.jx.service.impl;

import com.jx.bean.Stu;
import com.jx.comment.Pager;
import com.jx.dao.StuDAO;
import com.jx.service.StuService;
import com.jx.vo.StuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/22.
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDAO stuDAO;

    @Override
    public void save(Stu stu) {
        stuDAO.save(stu);
    }

    @Override
    public void remove(Stu stu) {
        stuDAO.remove(stu);
    }

    @Override
    public void removeById(Long id) {
        stuDAO.removeById(id);
    }

    @Override
    public void active(Long id, Byte status) {

    }

    @Override
    public void update(Stu stu) {
        stuDAO.update(stu);
    }

    @Override
    public Stu getById(Long id) {
        return null;
    }

    @Override
    public List<Stu> listAll() {
        return stuDAO.listAll();
    }

    @Override
    public Pager<Stu> listPager(int pageNo, int pageSize) {
        Pager<Stu> stuPager = new Pager<>(pageNo,pageSize);
        stuPager = stuDAO.listPager(stuPager);
        stuPager.setTotal(stuDAO.count());
        return stuPager;
    }

    @Override
    public Pager<Stu> listPagerCriteria(int pageNo, int pageSize, Stu stu) {
        Pager<Stu> pager = new Pager<>(pageNo, pageSize);
        pager.setTotal(stuDAO.countCriteria(stu));
        return stuDAO.listPagerCriteria(pager, stu);
    }

    @Override
    public List<StuVO> listAllWithClass() {
        return stuDAO.listAllWithClass();
    }
}
