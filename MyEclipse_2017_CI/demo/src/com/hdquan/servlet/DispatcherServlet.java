package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 对于@WebServlet("/")：不过滤JSP,放行JSP的功能（不运行当前程序），其他都过滤（即/xxx都运行现在该类的程序输出result）
 *对于@WebServlet("/*")：不放行任何东西
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet{
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String result = req.getParameter("control");
			System.out.println(result);
			if(result.equals("demo1"))
				demo1(req,res);
			if(result.equals("demo2"))
				demo2(req,res);
		}
		public void demo1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
		{
			System.out.println("demo1被调用");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
		public void demo2(HttpServletRequest req, HttpServletResponse res)
		{
			System.out.println("demo2被调用");
		}
		public void demo3(HttpServletRequest req, HttpServletResponse res)
		{
			System.out.println("demo3被调用");
		}
}
