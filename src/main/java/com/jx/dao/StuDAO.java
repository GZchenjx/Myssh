package com.jx.dao;

import com.jx.bean.Stu;
import com.jx.vo.StuVO;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/22.
 */
public interface StuDAO  extends BaseDAO<Stu>{

    List<StuVO> listAllWithClass();

}

