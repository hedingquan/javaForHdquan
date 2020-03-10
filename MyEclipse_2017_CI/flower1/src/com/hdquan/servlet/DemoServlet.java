package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")//鎵�鏈夎姹傞兘鑳芥帴鍙椼��
public class DemoServlet extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
System.out.println("aaa");
}
}
