package com.hdquan.controller;


import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class DemoController {
	@RequestMapping("demo1")
	public String demo1(HttpServletRequest abc,HttpSession sessionParam)
	{
		//request������
		abc.setAttribute("req", "req��ֵ");
		//session������
		HttpSession session=abc.getSession();//session��sessionParam��Ч
		session.setAttribute("session", "session��ֵ");
		sessionParam.setAttribute("sessionParam", "sessionParam��ֵ");
		
		//application������
		//������getServletContext����
		ServletContext application = abc.getServletContext();
		application.setAttribute("application", "application��ֵ");
		return "/index.jsp";
	}
	
	
	//���ٵش�session��������ȡ��ֵ----@SessionAttribute String session
//	@RequestMapping("demo2")
//	public String demo2(HttpSession session1,@SessionAttribute String session)
//	{
//		(1)��һ�ַ���
//		Object obj = session1.getAttribute("session");
//		System.out.println(obj);
//		�ڶ��ַ���
//		System.out.println(session);
//		return "/index.jsp";
//	}
	
	@RequestMapping("demo2")
	public String demo2(Map<String ,Object> map)
	{
		map.put("map", "map��ֵ");
		return "/index.jsp";
		
	}
	
	@RequestMapping("demo3")
	public String demo3(Model model)
	{
		model.addAttribute("model", "model��ֵ");
		return "/index.jsp";
	}
	
	@RequestMapping("demo4")
	public ModelAndView demo4()
	{
//		��������ת��ͼ
		ModelAndView mav=new ModelAndView("/index.jsp");
		mav.addObject("mav","mav��ֵ");
		return mav;
	}
}
