package com.jx.service;

import com.jx.bean.Teacher;
import com.jx.comment.Pager;

/**
 * Created by CHEN JX on 2017/11/27.
 */
public interface TeacherService extends BaseService<Teacher> {

    void saveClasses(Long teacherId, String clazzsId);
    Pager<Teacher> listPagerCriteria1(int limit, int offset, Teacher teacher);
}


