package com.hdquan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.pojo.User;
import com.hdquan.service.UserService;


@Controller
public class UserAction{

	@Autowired
	private UserService userService;
	@RequestMapping("login")
	public String getLogin()
	{
		 User user=new User();
		User u = userService.queryByNameAndPwd(user);
		System.out.println("11111");
		return "/login.jsp";
	}
}
