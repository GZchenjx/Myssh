package com.jx.service;

import com.jx.comment.Pager;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/22.
 */
public interface BaseService<T> {
    void save(T t);
    void remove(T t);
    void removeById(Long id);
    void active(Long id, Byte status);
    void update(T t);

    T getById(Long id);
    List<T> listAll();
    Pager<T> listPager(int pageNo, int pageSize);

    Pager<T> listPagerCriteria(int pageNo,int pageSize,T t);

}
