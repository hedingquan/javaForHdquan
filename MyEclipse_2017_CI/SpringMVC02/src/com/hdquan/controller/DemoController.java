package com.hdquan.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdquan.pojo.Demo;
import com.hdquan.pojo.People;

//交给容器去处理
@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo(@RequestParam(value="name1")String name,@RequestParam(value="age1")int age)
	{
		System.out.println("执行demo"+""+name+""+age);
		return "main.jsp";
	}
	@RequestMapping("page")
	public String page(@RequestParam(defaultValue="2")int pageSize,@RequestParam(defaultValue="1")int pageNumber)
	{
		System.out.println(pageSize+""+pageNumber);
		return "main.jsp";
	}
	@RequestMapping("demo2")
	public String demo2(@RequestParam(required=true)String name)
	{
		System.out.println("name是SQL的查询条件，必须要传递name参数"+name);
		return "main.jsp";
	}
	@RequestMapping("demo3")
	public String demo3(@RequestParam(required=true,defaultValue="测试")String name)
	{
		System.out.println(name);
		return "main.jsp";
	}
	@RequestMapping("demo4")
	public String demo4(People peo)
	{
		return "main.jsp";
	}
	@RequestMapping("demo5")
	public String demo5(String name1,int age1,@RequestParam("hover")List<String> hover)
	{
		System.out.println(name1+""+age1+""+hover);
		return "main.jsp";
	}
	@RequestMapping("demo6")
	public String demo6(Demo demo)
	{
		System.out.println(demo.toString()+"");
		return "main.jsp";
	}
	//对于<a href="demo7?id=123&name=abc">跳转</a>
	@RequestMapping("demo7")
	public String demo7(String name,int age)
	{
		System.out.println(name+""+age+"");
		return "main.jsp";
	}
	//对于	<a href="demo8/123/abc">跳转</a>
	@RequestMapping("demo8/{id1}/{name1}")
	public String demo8(@PathVariable(value="name1") String name,@PathVariable(value="id1")int age)
	{
		System.out.println(name+""+age+"");
		return "/main.jsp";//注意这个此时是为全路径
	}
	@RequestMapping("demo9")
	public String demo9()
	{
		System.out.println("转发");
		return "redirect:/main.jsp";
	}
	//	<property name="prefix" value="/abcdf"></property>	加上前缀
	@RequestMapping("demo10")
	public String demo10()
	{
		return "main.jsp";
	}
//	若加上forward或redirect(不走自定义解析器方式,即认为是一个控制器，走控制器)就不执行上列的加上前缀
//	@RequestMapping("demo12")
//	public String demo12()
//	{
//		return "forward:main.jsp";
//	}
	@RequestMapping("demo11")
	public String demo11()
	{
		return "forward:demo12";//若写return "demo12";的话，认为是一个解析器，会找不到demo12控制器
		
	}
	@RequestMapping("demo12")
	public String demo12()
	{
		return "main";
	}
	//不跳转的话用void,只要有返回值都是跳转，即使返回的是People类型的
	@RequestMapping("demo13")
	public void demo13(HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		out.print("abc");
		out.flush();
		out.close();
	}
	@RequestMapping("demo14")
	@ResponseBody
	public People demo14() throws IOException
	{
		People p=new People();
		p.setAge(12);
		p.setName("张三");
		return p;
	}
	@RequestMapping(value="demo15",produces="text/html;charset=utf-8")//设置响应头(Content-Type: text/html;charset=utf-8)格式为：text/html;charset=utf-8
	@ResponseBody
	public String demo15() throws IOException
	{
		People p=new People();
		p.setAge(12);
		p.setName("张三");
		return "中文";
	}
//	@RequestMapping("page")
//	//Integer变成int会报错，int没有赋值，但Integer系统会自动赋值为null
//	public String page(Integer pageSize,Integer pageNumber)
//	{
//		System.out.println(pageSize+""+pageNumber);
//		return "main.jsp";
//	}
//	@RequestMapping("demo")
//	public String demo(People people,String name,int age,HttpServletRequest req,HttpSession session)//index.jsp的内容全部都由springmvc自动注入
//	{
//		System.out.println("执行demo"+people.toString()+""+name+""+age);
//		req.setAttribute("demo123", "测试");
//		return "main.jsp";
//	}
	//控制器的呼叫方式为demo
//	@RequestMapping("demo")
//	public String demo(String name,int age)//index.jsp的内容全部都由springmvc自动注入
//	{
//		//	"/main.jsp"代表全路径
//		//	"main.jsp"代表相对路径，相对于当前控制器的相对路径,即在根目录demo文件下有main.jsp
//		System.out.println("执行demo"+name+""+age);
//		return "main.jsp";
//	}
//	@RequestMapping("demo2")
//	public String demo2()
//	{
//		System.out.println("demo2");
//		return "main1.jsp";
//	}
	
}
