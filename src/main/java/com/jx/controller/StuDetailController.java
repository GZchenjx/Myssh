package com.jx.controller;

import com.jx.bean.StuDetail;
import com.jx.enums.ClazzControllerStatusEnums;
import com.jx.enums.StuDetailControllerStatusEnums;
import com.jx.service.StuDetailService;
import com.jx.vo.ClazzControllerStatusVO;
import com.jx.vo.StuDetailControllerStatusVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by CHEN JX on 2017/11/24.
 */
@Controller
@ParentPackage("base-package")
@Namespace("/stuDetail")
public class StuDetailController extends BaseController{

    @Autowired
    private StuDetailService stuDetailService;


    private StuDetailControllerStatusVO statusVO;

    private StuDetail stuDetail;

    private Long stuDetailId;

    @Action(value = "get",results = {@Result(name="get",type = "json",params = {"root","stuDetail"})})
    public String get() {
        stuDetail = stuDetailService.getById(stuDetailId);
        return "get";
    }
    @Action(value = "save", results = {@Result(name = "save", type = "json", params = {"root", "statusVO"})})
    public String save() {
        stuDetailService.save(stuDetail);
        statusVO = StuDetailControllerStatusVO.Status(StuDetailControllerStatusEnums.STUDETAIL_SAVE_SUCCESS);
        return "save";
    }

    @Action(value = "update", results = {@Result(name = "update", type = "json", params = {"root", "statusVO"})})
    public String update() {
        if (stuDetail.getId() == null) {
            stuDetailService.save(stuDetail);
        } else {
            stuDetailService.update(stuDetail);
        }
        statusVO = StuDetailControllerStatusVO.Status(StuDetailControllerStatusEnums.STUDETAIL_UPDATE_SUCCESS);
        return "update";
    }

    @Action(value = "remove", results = {@Result(name = "remove", type = "json", params = {"root", "statusVO"})})
    public String remove() {
        stuDetailService.remove(stuDetail);
        statusVO = StuDetailControllerStatusVO.Status(StuDetailControllerStatusEnums.STUDETAIL_REMOVE_SUCCESS);
        return "remove";
    }

    public StuDetail getStuDetail() {
        return stuDetail;
    }

    public void setStuDetail(StuDetail stuDetail) {
        this.stuDetail = stuDetail;
    }

    public StuDetailControllerStatusVO getStatusVO() {
        return statusVO;
    }

    public void setStuDetailId(Long stuDetailId) {
        this.stuDetailId = stuDetailId;
    }
}
