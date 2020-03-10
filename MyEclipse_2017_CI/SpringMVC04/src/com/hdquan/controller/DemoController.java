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
	//�����Ļ���void����Ҫ��ת�Ļ���String����
	@RequestMapping("download")
	public void download(String fileName,HttpServletResponse res,HttpServletRequest req) throws IOException
	{
//		PrintWriter out=res.getWriter();//�����ķ�ʽ���ļ����ȥ������ַ���
//		res.getContentType();
		//������Ӧ�����ļ���������
		res.setHeader("Content-Disposition", "attachment;filename"+fileName);
//		res.setHeader("Content-Disposition", "inline");//���������أ����߹ۿ�
		//�Ѷ����������뵽��Ӧ����
		ServletOutputStream os = res.getOutputStream();//�ֽ���
		String path=req.getServletContext().getRealPath("images");//ȡ��Ӧ�ó������---getServletContext;ȡ����Դ�ļ��е�����·��--getRealPath
//		System.out.println(path);
		File file = new File(path,fileName);
		byte[] bytes = FileUtils.readFileToByteArray(file);//����������,���ļ������ֽ�����
		os.write(bytes);
		os.flush();
		os.close();
	}
}
