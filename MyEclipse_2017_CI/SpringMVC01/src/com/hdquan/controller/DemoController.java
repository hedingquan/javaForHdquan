package com.hdquan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DemoController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ִ����springMVC�Ŀ�����");//��ִ���˴��˵�����Խ���cotroller������
		ModelAndView mav=new ModelAndView("main");
		return mav;
	}
	
}
