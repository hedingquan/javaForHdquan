package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.pojo.PageInfo;
import com.hdquan.service.PeopleServlet;
import com.hdquan.service.impl.PeopleServletImpl;

@WebServlet("/page")
public class ShowPageServlet extends HttpServlet{
	PeopleServlet peopleServlet=new PeopleServletImpl();
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//第一次访问的验证，如果没有传递参数，设置默认值
		String pageSizeStr=req.getParameter("pageSize");
		int pageSize=2;
		if(pageSizeStr!=null&&!pageSizeStr.equals(""))
		{
			pageSize=Integer.parseInt(req.getParameter("pageSize"));
		}
		String pageNumberStr=req.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals(""))
		{
			pageNumber=Integer.parseInt(req.getParameter("pageNumber"));
		}
		PageInfo pi=peopleServlet.showpage(pageSize, pageNumber);
			req.setAttribute("PageInfo", pi);
			req.getRequestDispatcher("index.jsp").forward(req, res);;
	}
}
