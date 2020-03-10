package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.pojo.PageInfo;
import com.hdquan.service.StudentService;
import com.hdquan.service.Impl.StudentServiceImpl;

@WebServlet("/show")
public class ShowServlet extends HttpServlet{
	private StudentService studentService=new StudentServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("aaa");
			String sname = req.getParameter("sname");
			String tname = req.getParameter("tname");
			String pageSize = req.getParameter("pageSize");
			String pageNumber = req.getParameter("pageNumber");
		PageInfo pi = studentService.showPage(sname, tname, pageSize, pageNumber);
		req.setAttribute("PageInfo", pi);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
