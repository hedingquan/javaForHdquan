package com.hdquan.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	@RequestMapping("register")
	public String register(Users users,MultipartFile file,HttpServletRequest req)
	{
		String fileName=UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path=req.getServletContext().getRealPath("images")+"/"+fileName;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(users.toString());
		//ֻ�����ȡ��Webapps�ļ������ݣ���ĳ�����������������ļ���������ȡ�����ģ�
		users.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(users);
		if(index>0)
		{
			return "redirect:/show";
		}else
		{
			//redirect��ֹ�ظ��ύ�������Ļ��Ͳ�����ҳ�洫ֵ�ˣ����봫ֵ�Ļ�����Ҫͨ��session��ֵ
			return "redirect:/register.jsp";
		}
	}
}
