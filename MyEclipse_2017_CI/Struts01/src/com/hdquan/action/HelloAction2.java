package com.hdquan.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;


//使用接口注入表单数据
public class HelloAction2 extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public String execute() throws Exception {
		request.getParameter("");
		return super.execute();
	}

}
