package com.jx.enums;

/**
 * Created by CHEN JX on 2017/11/30.
 */
public enum StuDetailControllerStatusEnums {

    STUDETAIL_SAVE_SUCCESS(100,"success","学生详情添加成功"),
    STUDETAIL_SAVE_FAIL(101, "fail", "学生详情添加失败，稍候再试"),
    STUDETAIL_REMOVE_SUCCESS(102, "success", "学生详情删除成功"),
    STUDETAIL_REMOVE_FAIL(103, "fail", "学生详情删除失败"),
    STUDETAIL_UPDATE_SUCCESS(104, "success", "学生详情更新成功"),
    STUDETAIL_UPDATE_FAIL(105, "fail", "学生详情更新失败，稍候再试");

    private Integer code;
    private String result;
    private String msg;

    StuDetailControllerStatusEnums(Integer code, String result, String msg) {
        this.code = code;
        this.result = result;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
