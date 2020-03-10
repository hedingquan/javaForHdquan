package com.hdquan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdquan.pojo.Users;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("执行控制器");
		String name = req.getParameter("name");
		
		
		Users users=new Users();
		users.setId(1);
		users.setPassword("123");
		users.setUsername("张三");
		Users users1=new Users();
		users1.setId(2);
		users1.setPassword("222");
		users1.setUsername("李四");
			List<Users> list=new ArrayList<Users>();
			list.add(users1);
			list.add(users);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);//转换成String类型进行输出
		
		
//		int i=5/0;
//	PrintWriter out = res.getWriter();
//	out.print("<b>内容</b>");
//	out.flush();
//		ajax是不能写跳转语句的
//		res.sendRedirect("/ajax/index.jsp");//执行过程是demo-》index-》demo
		
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("服务器返回的内容"+name);
//		out.flush();
//		out.close();
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
}
