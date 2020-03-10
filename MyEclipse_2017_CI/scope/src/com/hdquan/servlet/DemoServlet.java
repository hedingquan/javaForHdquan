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
		//��ʼ����ʱ������
		public void init() throws ServletException {
//			�����ڳ�ʼ������Ļ�������������ʼ��һ�Σ���˺��涼����ͬ��
//			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());//ȡ��spring����
//			People people1=wac.getBean("peo",People.class);//�ٴ�Spring������ȡ��
//			People people2=wac.getBean("peo",People.class);
//			System.out.println("���"+people2);
//			System.out.println("���"+people1);
		}
		@Override
		//����servlet��ʱ������
		public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());//ȡ��spring����
			People people1=wac.getBean("peo",People.class);//�ٴ�Spring������ȡ��
			People people2=wac.getBean("peo",People.class);
			System.out.println("���"+people2);
			System.out.println("���"+people1);
		}
}
