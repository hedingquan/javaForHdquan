package com.hdquan.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		PrintWriter writer = res.getWriter();//输出文字流
		ServletOutputStream outputStream = res.getOutputStream();//获取响应流
		InputStream is=new FileInputStream(new File(getServletContext().getRealPath("images"),"wmpnss_color120.jpg"));
		int index=-1;
		while((index=is.read())!=-1)
		{
			outputStream.write(index);
		}
	}
}
