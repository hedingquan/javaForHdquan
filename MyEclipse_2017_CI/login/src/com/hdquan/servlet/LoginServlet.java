package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;
import com.hdquan.service.impl.UsersServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
		private UsersService usersService;
		@Override
		public void init() throws ServletException {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
			usersService=wac.getBean("UsersService",UsersServiceImpl.class);//默认情况下，AOP是进行JDBC动态代理，它把代理对象（UsersServiceImpl.class）不能转成实现类
		}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Users users=new Users();
		users.setUsername(req.getParameter("username"));
		users.setPassword(req.getParameter("password"));
		System.out.println(req.getParameter("usersname"));
		Users user = usersService.login(users);
		if(user!=null)
		{
			res.sendRedirect("main.jsp");
		}
		else
		{
			res.sendRedirect("login.jsp");
		}
	}
}
