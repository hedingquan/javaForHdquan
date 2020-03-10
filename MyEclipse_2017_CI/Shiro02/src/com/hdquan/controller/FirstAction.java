package com.hdquan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.pojo.User;

@Controller
public class FirstAction {
@RequestMapping("/first")
public String first(Model model)throws Exception
{
	//从shiro的session中取出User
	Subject subject=SecurityUtils.getSubject();
	//subject.getPrincipal()取出身份信息--是CustomRealm中的simpleAuthenticationInfo函数中Object principal传过来的值
	User user=(User)subject.getPrincipal();
	//通过model传到页面
	model.addAttribute("user", user);
		return "/first";
}
}
