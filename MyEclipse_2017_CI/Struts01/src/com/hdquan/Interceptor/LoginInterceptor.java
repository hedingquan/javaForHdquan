package com.hdquan.Interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	//这个方法里面写拦截器逻辑
	protected String doIntercept(ActionInvocation invocation) throws Exception {
	HttpServletRequest request = ServletActionContext.getRequest();
	Object obj = request.getSession().getAttribute("username");
	if(obj!=null){
		//放行
		return invocation.invoke();
	}else{
		return "login";//result标签的name对应值，到配置路径里面值
	}
	}
}
