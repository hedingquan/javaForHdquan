package com.hdquan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
@Override
public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
		throws Exception {
//	http://localhost:8080/SpringMVC08/login，所谓的URI即指   /SpringMVC08/login
	String uri = req.getRequestURI();
	System.out.println(uri);
//	if(uri.endsWith("login"))//以什么结尾的方式
	if(uri.equals("/SpringMVC08/login"))
	{
		return true;
	}
	else
	{
	Object obj = req.getSession().getAttribute("users");
		if(obj!=null)
		{
			return true;
		}
	res.sendRedirect("/SpringMVC08/login.jsp");
	return false;
	}
	}
}
