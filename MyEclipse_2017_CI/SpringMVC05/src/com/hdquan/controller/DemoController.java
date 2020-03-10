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
	//MultipartFile file的“file”必须和index.jsp文件中的文件：<input type="file" name="file"/>的name对应
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name) throws IOException
	{
//		MultipartResolver mr=null;
		System.out.println("name:"+name);
//		FileUtils.copyFile(file, destFile);
		String Filename = file.getOriginalFilename();//有些游览器获取到文件名，有些游览器获取到全路径
		String suffix = Filename.substring(Filename.lastIndexOf("."));//取出它的点以它后面的内容，不包括前面的内容
			//判断上传文件类型
		if(suffix.equalsIgnoreCase(".png"))
		{//equalsIgnoreCase表示不管大小写，只要大小写一致即相等
		String uuid = UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/"+uuid+suffix));//第一个得到文件流，第二个表示存哪里
		return "/index.jsp";
		}else
		{
			return "error.jsp";
		}
	}
}
