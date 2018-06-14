package com.jx.enums;

/**
 * Created by CHEN JX on 2017/11/30.
 */
public enum StuControllerStatusEnums {

    STU_SAVE_SUCCESS(100,"success","学生添加成功"),
    STU_SAVE_FAIL(101, "fail", "学生添加失败，稍候再试"),
    STU_REMOVE_SUCCESS(102, "success", "学生删除成功"),
    STU_REMOVE_FAIL(103, "fail", "学生删除失败"),
    STU_UPDATE_SUCCESS(104, "success", "学生更新成功"),
    STU_UPDATE_FAIL(105, "fail", "学生更新失败，稍候再试");

    private Integer code;
    private String result;
    private String msg;

    StuControllerStatusEnums(Integer code, String result, String msg) {
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
