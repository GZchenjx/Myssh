package com.jx.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CHEN JX on 2017/11/22.
 */
public class BaseController extends ActionSupport implements ServletRequestAware,ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    public HttpServletRequest getRequest() {
        return request;
    }
    public HttpServletResponse getResponse() {
        return response;
    }
}
