package com.hdquan.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
@Controller
public class DemoController {
	//MultipartFile file�ġ�file�������index.jsp�ļ��е��ļ���<input type="file" name="file"/>��name��Ӧ
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name) throws IOException
	{
//		MultipartResolver mr=null;
		System.out.println("name:"+name);
//		FileUtils.copyFile(file, destFile);
		String Filename = file.getOriginalFilename();//��Щ��������ȡ���ļ�������Щ��������ȡ��ȫ·��
		String suffix = Filename.substring(Filename.lastIndexOf("."));//ȡ�����ĵ�������������ݣ�������ǰ�������
			//�ж��ϴ��ļ�����
		if(suffix.equalsIgnoreCase(".png"))
		{//equalsIgnoreCase��ʾ���ܴ�Сд��ֻҪ��Сдһ�¼����
		String uuid = UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/"+uuid+suffix));//��һ���õ��ļ������ڶ�����ʾ������
		return "/index.jsp";
		}else
		{
			return "error.jsp";
		}
	}
}
