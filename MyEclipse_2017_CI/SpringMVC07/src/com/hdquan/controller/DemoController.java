package com.hdquan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DemoController {
//	@RequestMapping("demo")	
//	public String demo()
//		{
//			System.out.println("ִ��demo");
//			return "/index.jsp";
//		}
	
	
	@RequestMapping("demo4")	
	public String demo(Model model)
		{
			System.out.println("ִ��demo");
//			int i=1/0;
			model.addAttribute("model", "���Ƕ������");
			return "/index.jsp";
		}
}
