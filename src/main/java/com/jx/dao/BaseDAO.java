package com.jx.dao;

import com.jx.comment.Pager;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/21.
 */
public interface BaseDAO<T>{

    void save(T t);
    void remove(T t);
    void removeById(Long id);
    void activice(Long id,Byte status);
    void update(T t);

    T getById(Long id);
    List<T> listAll();
    Pager<T> listPager(Pager<T> pager);

    Long count();

    Pager<T> listPagerCriteria(Pager<T> pager,T t);
    Long countCriteria(T t);

}
