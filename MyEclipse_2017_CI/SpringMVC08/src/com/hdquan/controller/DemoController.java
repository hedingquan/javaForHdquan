package com.hdquan.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.pojo.Users;
@Controller
public class DemoController {
	@RequestMapping("{page}")//{page}��ʾ��ҳ����ʱ�Ĳ���
	public String main(@PathVariable String page)//{page}=page
	{
		System.out.println("restful");
		return page;
	}
	//���������������Ļ�����������{page}�ǿ��������κεģ����ǻ�����ƥ����Ǹ���
	//��login����ȻҲ����������@RequestMapping("{page}")�����ǻ�����ƥ��������login��
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
			return "main";//��ҳ�����ͼ������
		}
		else
			{return "redirect:/login.jsp";}
			//�߿�����;
			}
	}
