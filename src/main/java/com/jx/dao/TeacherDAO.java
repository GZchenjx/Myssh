package com.jx.dao;

import com.jx.bean.Teacher;
import com.jx.comment.Pager;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/27.
 */
public interface TeacherDAO extends BaseDAO<Teacher> {

    void save(Long teacherId,List<Long> clazzsId);
    Pager<Teacher> listPagerCriteria1(Pager<Teacher> pager,Teacher teacher);
}


