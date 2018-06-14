package com.jx.enums;

/**
 * Created by CHEN JX on 2017/11/23.
 */
public enum ClazzControllerStatusEnums {
    CLAZZ_SAVE_SUCCESS(100,"success","班级添加成功"),
    CLAZZ_SAVE_FAIL(101, "fail", "班级添加失败，稍候再试"),
    CLAZZ_REMOVE_SUCCESS(102, "success", "班级删除成功"),
    CLAZZ_REMOVE_FAIL(103, "fail", "班级删除失败"),
    CLAZZ_UPDATE_SUCCESS(104, "success", "班级更新成功"),
    CLAZZ_UPDATE_FAIL(105, "fail", "班级更新失败，稍候再试");

    private Integer code;
    private String result;
    private String msg;

    ClazzControllerStatusEnums(Integer code, String result, String msg) {
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
