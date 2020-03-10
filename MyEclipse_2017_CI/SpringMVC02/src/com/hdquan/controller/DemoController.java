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

//��������ȥ����
@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo(@RequestParam(value="name1")String name,@RequestParam(value="age1")int age)
	{
		System.out.println("ִ��demo"+""+name+""+age);
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
		System.out.println("name��SQL�Ĳ�ѯ����������Ҫ����name����"+name);
		return "main.jsp";
	}
	@RequestMapping("demo3")
	public String demo3(@RequestParam(required=true,defaultValue="����")String name)
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
	//����<a href="demo7?id=123&name=abc">��ת</a>
	@RequestMapping("demo7")
	public String demo7(String name,int age)
	{
		System.out.println(name+""+age+"");
		return "main.jsp";
	}
	//����	<a href="demo8/123/abc">��ת</a>
	@RequestMapping("demo8/{id1}/{name1}")
	public String demo8(@PathVariable(value="name1") String name,@PathVariable(value="id1")int age)
	{
		System.out.println(name+""+age+"");
		return "/main.jsp";//ע�������ʱ��Ϊȫ·��
	}
	@RequestMapping("demo9")
	public String demo9()
	{
		System.out.println("ת��");
		return "redirect:/main.jsp";
	}
	//	<property name="prefix" value="/abcdf"></property>	����ǰ׺
	@RequestMapping("demo10")
	public String demo10()
	{
		return "main.jsp";
	}
//	������forward��redirect(�����Զ����������ʽ,����Ϊ��һ�����������߿�����)�Ͳ�ִ�����еļ���ǰ׺
//	@RequestMapping("demo12")
//	public String demo12()
//	{
//		return "forward:main.jsp";
//	}
	@RequestMapping("demo11")
	public String demo11()
	{
		return "forward:demo12";//��дreturn "demo12";�Ļ�����Ϊ��һ�������������Ҳ���demo12������
		
	}
	@RequestMapping("demo12")
	public String demo12()
	{
		return "main";
	}
	//����ת�Ļ���void,ֻҪ�з���ֵ������ת����ʹ���ص���People���͵�
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
		p.setName("����");
		return p;
	}
	@RequestMapping(value="demo15",produces="text/html;charset=utf-8")//������Ӧͷ(Content-Type: text/html;charset=utf-8)��ʽΪ��text/html;charset=utf-8
	@ResponseBody
	public String demo15() throws IOException
	{
		People p=new People();
		p.setAge(12);
		p.setName("����");
		return "����";
	}
//	@RequestMapping("page")
//	//Integer���int�ᱨ��intû�и�ֵ����Integerϵͳ���Զ���ֵΪnull
//	public String page(Integer pageSize,Integer pageNumber)
//	{
//		System.out.println(pageSize+""+pageNumber);
//		return "main.jsp";
//	}
//	@RequestMapping("demo")
//	public String demo(People people,String name,int age,HttpServletRequest req,HttpSession session)//index.jsp������ȫ������springmvc�Զ�ע��
//	{
//		System.out.println("ִ��demo"+people.toString()+""+name+""+age);
//		req.setAttribute("demo123", "����");
//		return "main.jsp";
//	}
	//�������ĺ��з�ʽΪdemo
//	@RequestMapping("demo")
//	public String demo(String name,int age)//index.jsp������ȫ������springmvc�Զ�ע��
//	{
//		//	"/main.jsp"����ȫ·��
//		//	"main.jsp"�������·��������ڵ�ǰ�����������·��,���ڸ�Ŀ¼demo�ļ�����main.jsp
//		System.out.println("ִ��demo"+name+""+age);
//		return "main.jsp";
//	}
//	@RequestMapping("demo2")
//	public String demo2()
//	{
//		System.out.println("demo2");
//		return "main1.jsp";
//	}
	
}
