package com.jx.enums;

/**
 * Created by CHEN JX on 2017/11/30.
 */
public enum TeacherControllerStatusEnums {

    TEACHER_SAVE_SUCCESS(100,"success","老师添加成功"),
    TEACHER_SAVE_FAIL(101, "fail", "老师添加失败，稍候再试"),
    TEACHER_REMOVE_SUCCESS(102, "success", "老师删除成功"),
    TEACHER_REMOVE_FAIL(103, "fail", "老师删除失败"),
    TEACHER_UPDATE_SUCCESS(104, "success", "老师更新成功"),
    TEACHER_UPDATE_FAIL(105, "fail", "老师更新失败，稍候再试");

    private Integer code;
    private String result;
    private String msg;

    TeacherControllerStatusEnums(Integer code, String result, String msg) {
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
