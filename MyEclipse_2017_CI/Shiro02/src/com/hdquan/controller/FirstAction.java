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
	//��shiro��session��ȡ��User
	Subject subject=SecurityUtils.getSubject();
	//subject.getPrincipal()ȡ�������Ϣ--��CustomRealm�е�simpleAuthenticationInfo������Object principal��������ֵ
	User user=(User)subject.getPrincipal();
	//ͨ��model����ҳ��
	model.addAttribute("user", user);
		return "/first";
}
}
