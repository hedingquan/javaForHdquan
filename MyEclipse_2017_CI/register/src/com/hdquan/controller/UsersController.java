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
		//只能最大取到Webapps文件夹内容，别的超过这个（即再深层的文件夹内容是取不到的）
		users.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(users);
		if(index>0)
		{
			return "redirect:/show";
		}else
		{
			//redirect防止重复提交，这样的话就不能向页面传值了，若想传值的话就需要通过session传值
			return "redirect:/register.jsp";
		}
	}
}
