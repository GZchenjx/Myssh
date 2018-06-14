package com.jx.vo;

import com.jx.enums.ClazzControllerStatusEnums;
import com.jx.enums.StuDetailControllerStatusEnums;

/**
 * Created by CHEN JX on 2017/11/23.
 */
public class StuDetailControllerStatusVO {

    private Integer code;//状态码
    private String result;
    private String msg;

    public StuDetailControllerStatusVO() {

    }

    public StuDetailControllerStatusVO(Integer code, String result, String msg) {
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

    public static StuDetailControllerStatusVO Status(StuDetailControllerStatusEnums controllerStatusEnums) {

        return new StuDetailControllerStatusVO(controllerStatusEnums.getCode(),controllerStatusEnums.getResult(),controllerStatusEnums.getMsg());
    }
}
