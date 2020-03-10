package com.hdquan.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.pojo.Users;
@Controller
public class DemoController {
	@RequestMapping("{page}")//{page}表示网页请求时的参数
	public String main(@PathVariable String page)//{page}=page
	{
		System.out.println("restful");
		return page;
	}
	//当有两个控制器的话，而且上面{page}是可以请求任何的，但是会走最匹配的那个，
	//如login，虽然也会进行上面的@RequestMapping("{page}")，但是会走最匹配的这个“login”
//	@RequestMapping("login")
//	public String login()
//	{
//		System.out.println("login");
//		return "/login.jsp";
//	}
	@RequestMapping("login")
	public String login(Users users,HttpSession session)
	{
		if(users.getUsername().equals("hdquan")&&users.getPassword().equals("123"))
		{
			session.setAttribute("users", users);		
			return "main";//走页面的视图解析器
		}
		else
			{return "redirect:/login.jsp";}
			//走控制器;
			}
	}
