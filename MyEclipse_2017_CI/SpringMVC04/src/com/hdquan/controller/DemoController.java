package com.hdquan.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DemoController {
	//不跳的话就void，需要跳转的话是String类型
	@RequestMapping("download")
	public void download(String fileName,HttpServletResponse res,HttpServletRequest req) throws IOException
	{
//		PrintWriter out=res.getWriter();//以流的方式将文件输出去。输出字符流
//		res.getContentType();
		//设置响应流中文件进行下载
		res.setHeader("Content-Disposition", "attachment;filename"+fileName);
//		res.setHeader("Content-Disposition", "inline");//不进行下载，在线观看
		//把二进制流放入到响应体中
		ServletOutputStream os = res.getOutputStream();//字节流
		String path=req.getServletContext().getRealPath("images");//取到应用程序对象---getServletContext;取到资源文件夹的完整路径--getRealPath
//		System.out.println(path);
		File file = new File(path,fileName);
		byte[] bytes = FileUtils.readFileToByteArray(file);//二进制数组,把文件读成字节数组
		os.write(bytes);
		os.flush();
		os.close();
	}
}
