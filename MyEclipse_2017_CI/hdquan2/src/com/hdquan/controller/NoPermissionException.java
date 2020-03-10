package com.hdquan.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

	@Controller
	public class NoPermissionException {
	    @ExceptionHandler(UnauthorizedException.class)
	    public String handleShiroException(Exception ex,HttpServletRequest request) {
	    	request.setAttribute("ex", "没有权限");  
	        return "/refuse.jsp"; 
	    }
	    @ExceptionHandler(AuthorizationException.class)
	    public String AuthorizationException(Exception ex,HttpServletRequest request) {
	    	request.setAttribute("exe", "权限认证失败");  
	        return "/error.jsp"; 
	    }
	}
