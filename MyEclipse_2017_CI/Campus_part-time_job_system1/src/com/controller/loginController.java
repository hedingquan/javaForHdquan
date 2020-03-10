package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Service.UserService;
import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;


@Controller
public class loginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login.action")
	public String login(HttpServletRequest req,HttpServletResponse response,String user_name,String user_password) throws IOException
	{
		Object user = userService.user(user_name);
		req.getServletContext().setAttribute("user_name", user_name);
		req.getServletContext().setAttribute("user", user);
		if(user==null)
		{
			return "redirect:/login.jsp";  
		}else if(!user_password.equals(((User)user).getUser_password())){			
			return "redirect:forget_password.jsp";  
		}else{			
			return "redirect:/myinfo.jsp";  
		}
	}
	
	@RequestMapping("register.action")
	public String register(HttpServletRequest req,HttpServletResponse response,String user_password,String user_name,String user_ID) throws IOException
	{
		
		String parameter = req.getParameter("user_type");
		if(parameter!=null&&"0".equals(parameter))
		{
			Cuser cuser=new Cuser();
			cuser.setUser_type("学生");
			cuser.setUser_name(user_name);
			cuser.setUser_password(user_password);
			cuser.setUser_ID(user_ID);
			userService.AddCuser(cuser);
		}else{
			Buser buser=new Buser();
			buser.setUser_type("商店老板");
			buser.setUser_name(user_name);
			buser.setUser_password(user_password);
			buser.setUser_ID(user_ID);
			userService.AddBuser(buser);
		}
		return "redirect:/login.jsp";  
	}
	
	@RequestMapping("forget_password.action")
	public String forget_password(HttpServletRequest req,HttpServletResponse response,String user_password,String user_name) throws IOException
	{
		Object user = userService.user(user_name);
		if(user instanceof Cuser)
		{
			((Cuser) user).setUser_password(user_password);
			userService.UpdateCuser((Cuser) user);
		}else if(user instanceof Admin)
		{
			((Admin) user).setUser_password(user_password);
			userService.UpdateAdmin((Admin) user);
		}else{
			((Buser) user).setUser_password(user_password);
			userService.UpdateBuser((Buser) user);
		}
		return "redirect:/login.jsp";  
	}
}
