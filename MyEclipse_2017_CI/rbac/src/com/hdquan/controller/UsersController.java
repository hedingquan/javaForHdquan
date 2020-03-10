package com.hdquan.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	@RequestMapping("login")
	public String login(Users users,HttpSession session)
	{
//	(1)	Users user=usersServiceImpl.login(users);
		Map<String,Object> map=usersServiceImpl.login(users);
		System.out.println(map);
		if(map.get("user")!=null)
		{
			session.setAttribute("user", map.get("user"));
			session.setAttribute("allurl", map.get("allurl"));
//		(1)	return "showAllUrl";
			return "redirect:/main.jsp";
		}
		else
		{
			return "redirect:/index.jsp";
		}
	}
	@RequestMapping("demo")
	public String demo()
	{
		System.out.println("Ö´ÐÐdemo");
		return "/main.jsp";
	}
}
