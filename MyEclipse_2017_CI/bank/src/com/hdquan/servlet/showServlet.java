package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.service.LogService;
import com.hdquan.service.impl.LogServiceImpl;

@WebServlet("/show")
public class showServlet extends HttpServlet{
	private LogService logService=new LogServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int pageSize=2;
	String pageSizeStr=req.getParameter("pageSize");
	if(pageSizeStr!=null&&pageSizeStr.equals(""))
	{
		pageSize=Integer.parseInt(pageSizeStr);
	}
	int pageNumber=1;
	String pageNumberStr=req.getParameter("pageNumber");
	if(pageNumberStr!=null&&pageNumberStr.equalsIgnoreCase(""))
	{
		pageNumber=Integer.parseInt(pageNumberStr);
	}
	req.setAttribute("PageInfo", logService.showPage(pageSize, pageNumber));
	req.getRequestDispatcher("/log.jsp").forward(req, res);;
}
}
