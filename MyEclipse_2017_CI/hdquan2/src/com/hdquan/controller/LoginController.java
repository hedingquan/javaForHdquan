package com.hdquan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
    
	@RequestMapping(path="/login.action")
	public String login(HttpServletRequest req,HttpServletResponse response) throws Exception
	{
		String shiroLoginFailure = (String) req.getAttribute("shiroLoginFailure");
		response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		if(shiroLoginFailure!=null)
		{
			if(UnknownAccountException.class.getName().equals(shiroLoginFailure))
			{
				req.setAttribute("msg", "账号不正确");
			}
			else if(IncorrectCredentialsException.class.getName().equals(shiroLoginFailure))
			{
				req.setAttribute("msg", "用户名/密码不正确");
			}
			else if("randomCodeError".equals(shiroLoginFailure))
			{
				req.setAttribute("msg", "验证码错误不正确");
			}
			else 
			{
			req.setAttribute("msg","登录失败");
			}
		}
		return "/login.jsp";
	}
	
	@RequestMapping("first.action")
	public String first(HttpServletResponse response) throws IOException
	{
		 return "redirect:/first.jsp";  
	}
 }
