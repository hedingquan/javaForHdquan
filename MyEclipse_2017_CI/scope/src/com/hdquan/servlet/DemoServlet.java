package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hdquan.pojo.People;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
		@Override
		//初始化的时候启动
		public void init() throws ServletException {
//			若放在初始化这里的话，这有启动初始了一次，因此后面都是相同的
//			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());//取出spring容器
//			People people1=wac.getBean("peo",People.class);//再从Spring容器中取出
//			People people2=wac.getBean("peo",People.class);
//			System.out.println("输出"+people2);
//			System.out.println("输出"+people1);
		}
		@Override
		//请求servlet的时候启动
		public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());//取出spring容器
			People people1=wac.getBean("peo",People.class);//再从Spring容器中取出
			People people2=wac.getBean("peo",People.class);
			System.out.println("输出"+people2);
			System.out.println("输出"+people1);
		}
}
