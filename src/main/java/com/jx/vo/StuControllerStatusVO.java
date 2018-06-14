package com.jx.vo;

import com.jx.enums.ClazzControllerStatusEnums;
import com.jx.enums.StuControllerStatusEnums;

/**
 * Created by CHEN JX on 2017/11/23.
 */
public class StuControllerStatusVO {

    private Integer code;//状态码
    private String result;
    private String msg;

    public StuControllerStatusVO() {

    }

    public StuControllerStatusVO(Integer code, String result, String msg) {
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

    public static StuControllerStatusVO Status(StuControllerStatusEnums controllerStatusEnums) {

        return new StuControllerStatusVO(controllerStatusEnums.getCode(),controllerStatusEnums.getResult(),controllerStatusEnums.getMsg());
    }
}
