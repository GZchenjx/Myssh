package com.jx.controller;

import com.jx.bean.Clazz;
import com.jx.comment.Combobox;
import com.jx.comment.Pager;
import com.jx.enums.ClazzControllerStatusEnums;
import com.jx.service.ClazzService;
import com.jx.vo.ClazzControllerStatusVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by CHEN JX on 2017/11/22.
 */
@Controller
@ParentPackage("base-package")
@Namespace("/clazz")
public class ClazzController extends BaseController{

    @Autowired
   private ClazzService clazzService;

    private Integer page;
    private Integer rows;
    private Pager<Clazz> pager;


    private List<Combobox> comboboxes ;
    private Long clazzId;
    private Clazz clazz;
    private ClazzControllerStatusVO statusVO;

    @Action(value = "class_page",results = {@Result(name="class_page",location = "/WEB-INF/views/clazz/clazz.jsp")})
    public String class_page() {
        return "class_page";
    }
    @Action(value = "save",results = {@Result(name = "save",type = "json",params = {"root","statusVO"})})
    public String save() {
        clazzService.save(clazz);
        statusVO = ClazzControllerStatusVO.Status(ClazzControllerStatusEnums.CLAZZ_SAVE_SUCCESS);
        return "save";
    }
    @Action(value = "remove",results = {@Result(name = "remove",type = "json",params = {"root","statusVO"})})
    public String remove() {
        clazzService.removeById(clazz.getId());
        statusVO = ClazzControllerStatusVO.Status(ClazzControllerStatusEnums.CLAZZ_REMOVE_SUCCESS);
        return "remove";
    }
    @Action(value = "update",results = {@Result(name = "update",type = "json",params = {"root","statusVO"})})
    public String update() {
        clazzService.update(clazz);
        statusVO = ClazzControllerStatusVO.Status(ClazzControllerStatusEnums.CLAZZ_UPDATE_SUCCESS);
        return "update";
    }

    @Action(value = "pager",results = {@Result(name = "pager",type = "json",params = {"root","pager"})})
    public String pager() {
        pager = clazzService.listPager(page, rows);
        return "pager";
    }
    @Action(value = "getId",results = {@Result(name = "getId",type = "json",params = {"root","clazz"})})
    public String getId() {
        clazz = clazzService.getById(clazz.getId());
        return "getId";
    }
    @Action(value = "pager_criteria",results = {@Result(name = "pager_criteria",type = "json",params = {"root","pager"})})
    public String pagerCriteria() {
        if (clazz == null) {
            clazz = new Clazz();
        }
        pager = clazzService.listPagerCriteria(page, rows, clazz);
        return "pager_criteria";
    }

    @Action(value = "all", results = {@Result(name = "all", type = "json", params = {"root", "comboboxes"})})
    public String all() {
        List<Clazz> clazzList = clazzService.listAll();
        comboboxes = new ArrayList<>();
        for (Clazz clazz : clazzList) {
            boolean selected = false;
            if (clazzId != null && clazz.getId().longValue() == clazzId.longValue()) {
                selected = true;
            }
            comboboxes.add(new Combobox(clazz.getId() + "", clazz.getTitle(), selected));
        }
        return "all";
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public ClazzControllerStatusVO getStatusVO() {
        return statusVO;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Pager<Clazz> getPager() {
        return pager;
    }

    public List<Combobox> getComboboxes() {
        return comboboxes;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }
}
