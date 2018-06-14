package com.jx.service;

import com.jx.bean.Stu;
import com.jx.vo.StuVO;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/22.
 */
public interface StuService extends BaseService<Stu> {

    List<StuVO> listAllWithClass();
}
