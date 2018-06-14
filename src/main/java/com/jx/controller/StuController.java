package com.jx.controller;

import com.jx.bean.Stu;
import com.jx.comment.Pager;
import com.jx.enums.ClazzControllerStatusEnums;
import com.jx.enums.StuControllerStatusEnums;
import com.jx.service.StuService;
import com.jx.vo.ClazzControllerStatusVO;
import com.jx.vo.StuControllerStatusVO;
import com.jx.vo.StuVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by CHEN JX on 2017/11/24.
 */
@Controller
@ParentPackage("base-package")
@Namespace("/stu")
public class StuController extends BaseController{

    @Autowired
    private StuService stuService;

    private List<StuVO> stuVOList;

    private Pager<Stu> pager;

    private StuControllerStatusVO statusVO;

    private Integer page;
    private Integer rows;
    private Stu stu;


    @Action(value = "save", results = {@Result(name = "save", type = "json", params = {"root", "statusVO"})})
    public String save() {
        stuService.save(stu);
        statusVO = StuControllerStatusVO.Status(StuControllerStatusEnums.STU_SAVE_SUCCESS);
        return "save";
    }
    @Action(value = "update", results = {@Result(name = "update", type = "json", params = {"root", "statusVO"})})
    public String update() {
        stuService.update(stu);
        statusVO = StuControllerStatusVO.Status(StuControllerStatusEnums.STU_UPDATE_SUCCESS);
        return "update";
    }
    @Action(value = "stu_all",results = {@Result(name = "stu_all",type = "json",params = {"root","stuVOList"})})
    public String StuVO() {
        stuVOList = stuService.listAllWithClass();
        return "stu_all";
    }

    @Action(value = "stu_page",results = {@Result(name="stu_page",location = "/WEB-INF/views/stu/students.jsp")})
    public String stu_page() {

        return "stu_page";
    }

    @Action(value = "pager_criteria",results = {@Result(name = "pager_criteria",type = "json",params = {"root","pager"})})
    public String pagerCriteria() {
        if (stu == null) {
            stu = new Stu();
        }
        pager = stuService.listPagerCriteria(page, rows, stu);
        return "pager_criteria";
    }

    public List<StuVO> getStuVOList() {
        return stuVOList;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }


    public void setStuVOList(List<StuVO> stuVOList) {
        this.stuVOList = stuVOList;
    }

    public Pager<Stu> getPager() {
        return pager;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public StuControllerStatusVO getStatusVO() {
        return statusVO;
    }
}
