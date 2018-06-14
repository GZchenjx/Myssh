package com.jx.bean;

import java.util.Set;

public class Stu {
    private Long id;
    private String num;
    private String realName;

    private Clazz clazz;
    private StuDetail stuDetail;//一个学生有一个学生详情

    private Set<Contract> contractSet;//一个学生有多个联系人

    public StuDetail getStuDetail() {
        return stuDetail;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public void setStuDetail(StuDetail stuDetail) {
        this.stuDetail = stuDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }



    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
