package com.hdquan.controller;

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
		Users user=usersServiceImpl.login(users);
		System.out.println(user);
		if(user!=null)
		{
			session.setAttribute("user", user);
			return "redirect:/main.jsp";
		}
		else
		{
			return "redirect:/index.jsp";
		}
	}
}
