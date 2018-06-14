package com.jx.controller;

import com.jx.bean.Clazz;
import com.jx.bean.Teacher;
import com.jx.comment.Pager;
import com.jx.enums.ClazzControllerStatusEnums;
import com.jx.enums.TeacherControllerStatusEnums;
import com.jx.service.TeacherService;
import com.jx.vo.ClazzControllerStatusVO;
import com.jx.vo.TeacherControllerStatusVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHEN JX on 2017/11/24.
 */
@Controller
@ParentPackage("base-package")
@Namespace("/teacher")
public class TeacherController extends BaseController{

    private List<Teacher> columns;

    public List<com.jx.bean.Teacher> getColumns() {
        return columns;
    }

    @Autowired
    private TeacherService teacherService;

    private Pager<Clazz> clazzPager;

    private Pager<Teacher> pager;

    private TeacherControllerStatusVO statusVO;

    private Integer page;
    private Integer rows;
    private Teacher Teacher;

    private Long teacherId;
    private String clazzIds;

    private Integer limit;
    private Integer offset;

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Action(value = "save", results = {@Result(name = "save", type = "json", params = {"root", "statusVO"})})
    public String save() {
        teacherService.save(Teacher);
        statusVO = TeacherControllerStatusVO.Status(TeacherControllerStatusEnums.TEACHER_SAVE_SUCCESS);
        return "save";
    }

    @Action(value = "save_clazz", results = {@Result(name = "save_clazz", type = "json", params = {"root", "statusVO"})})
    public String save_clazz() {
        teacherService.saveClasses(teacherId,clazzIds);
        statusVO = TeacherControllerStatusVO.Status(TeacherControllerStatusEnums.TEACHER_SAVE_SUCCESS);
        return "save_clazz";
    }
    @Action(value = "update", results = {@Result(name = "update", type = "json", params = {"root", "statusVO"})})
    public String update() {
        teacherService.update(Teacher);
        statusVO = TeacherControllerStatusVO.Status(TeacherControllerStatusEnums.TEACHER_UPDATE_SUCCESS);
        return "update";
    }

    @Action(value = "teacher_page",results = {@Result(name="teacher_page",location = "/WEB-INF/views/teacher/teacher.jsp")})
    public String Teacher_page() {

        return "teacher_page";
    }
    @Action(value = "teacher_page1",results = {@Result(name="teacher_page1",location = "/WEB-INF/views/teacher/teacherTest.jsp")})
    public String Teacher_page1() {

        return "teacher_page1";
    }


    @Action(value = "pager_criteria",results = {@Result(name = "pager_criteria",type = "json",params = {"root","pager"})})
    public String pagerCriteria() {
        if (Teacher == null) {
            Teacher = new Teacher();
        }
        pager = teacherService.listPagerCriteria(page, rows, Teacher);
        return "pager_criteria";
    }

    @Action(value = "clazz", results = {@Result(name = "clazz", type = "json", params = {"root", "clazzPager"})})
    public String classes() {
        clazzPager = new Pager<>();
        List<Clazz> clazzList = new ArrayList<>();
        clazzList.addAll(teacherService.getById(teacherId).getClazzSet());
        clazzPager.setRows(clazzList);
        clazzPager.setTotal(new Long(clazzList.size()));
        clazzPager.setPageNo(1);
        clazzPager.setPageSize(100);
        return "clazz";
    }
    @Action(value = "pager_criteria1",results = {@Result(name = "pager_criteria1",type = "json",params = {"root","columns"})})
    public String pagerCriteria1() {
        if (Teacher == null) {
            Teacher = new Teacher();
        }
        pager = teacherService.listPagerCriteria1(limit, offset,Teacher);
        columns = pager.getRows();
        return "pager_criteria1";
    }

    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }


    public Pager<Clazz> getClazzPager() {
        return clazzPager;
    }

    public Pager<Teacher> getPager() {
        return pager;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public TeacherControllerStatusVO getStatusVO() {
        return statusVO;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setClazzIds(String clazzIds) {
        this.clazzIds = clazzIds;
    }
}
