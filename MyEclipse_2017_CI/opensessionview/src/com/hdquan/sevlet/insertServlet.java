package com.hdquan.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.pojo.Log;
import com.hdquan.service.LogService;
import com.hdquan.service.impl.LogServiceImpl;

@WebServlet("/insert")
public class insertServlet extends HttpServlet{
	private LogService logService =new LogServiceImpl();
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	Log log=new Log();
	log.setAccIn(req.getParameter("accIn"));
	log.setAccOut(req.getParameter("accOut"));
	log.setMoney(Double.parseDouble(req.getParameter("money")));
	int index = logService.ins(log);
	if(index>0)
	{
		res.sendRedirect("index.jsp");
	}
	else{
	
	}
}
}
