package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hdquan.service.AirportService;
import com.hdquan.service.impl.AirportServiceImpl;

@WebServlet("/airport")
public class AirportServlet extends HttpServlet{
	private AirportService airportService;
	
	
	public void init() throws ServletException {
	//对service实例化
//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//spring和web整合后所有信息都存放在webApplicationContext
		ServletContext servletContext = getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		airportService=ac.getBean("airportService",AirportServiceImpl.class);
	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	req.setAttribute("list",airportService.show());
	req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
