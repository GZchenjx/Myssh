package com.jx.bean;

import org.apache.struts2.json.annotations.JSON;

import java.util.Set;

public class Teacher {
    private Long id;
    private String name;
    private String phone;

    private Set<Clazz> clazzSet;//一个老师有多个班级

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JSON(serialize = false)
    public Set<Clazz> getClazzSet() {
        return clazzSet;
    }

    public void setClazzSet(Set<Clazz> clazzSet) {
        this.clazzSet = clazzSet;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
