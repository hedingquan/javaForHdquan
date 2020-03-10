package com.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Service.UserService;
import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("Search_myinfo.action")
	public void myinfo(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String user_name = (String)req.getServletContext().getAttribute("user_name");
		Object user = userService.user(user_name);
		if(user instanceof Cuser)
		{
		req.setAttribute("user_type", ((Cuser)user).getUser_type());
		req.setAttribute("user_name", ((Cuser)user).getUser_name());
		req.setAttribute("user_ID", ((Cuser)user).getUser_ID());
		req.setAttribute("user_password", ((Cuser)user).getUser_password());
		}else if(user instanceof Admin)
		{
			req.setAttribute("user_type", ((Admin)user).getUser_type());
			req.setAttribute("user_name", ((Admin)user).getUser_name());
			req.setAttribute("user_ID", ((Admin)user).getUser_ID());
			req.setAttribute("user_password", ((Admin)user).getUser_password());
		}else{
			req.setAttribute("user_type", ((Buser)user).getUser_type());
			req.setAttribute("user_name", ((Buser)user).getUser_name());
			req.setAttribute("user_ID", ((Buser)user).getUser_ID());
			req.setAttribute("user_password", ((Buser)user).getUser_password());
		}
		req.getRequestDispatcher("Search_myinfo.jsp").forward(req, res);
	}
	
	@RequestMapping("change_myinfo.action")
	public void change_myinfo(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		User user = (User)req.getServletContext().getAttribute("user");
		String user_ID = user.getUser_ID();
		if(user instanceof Cuser)
		{
			Cuser cuser = userService.getCuser(user_ID);
			BeanUtils.populate(cuser, req.getParameterMap());
			cuser.setUser_name(req.getParameter("user_name"));
			cuser.setUser_ID(user_ID);
			userService.UpdateCuser(cuser);
			req.getServletContext().setAttribute("user_name", cuser.getUser_name());
			req.getServletContext().setAttribute("user", cuser);
		}else if(user instanceof Admin)
		{
			Admin admin = userService.getAdmin(user_ID);
			BeanUtils.populate(admin, req.getParameterMap());
			admin.setUser_name(req.getParameter("user_name"));
			admin.setUser_ID(user_ID);
			userService.UpdateAdmin(admin);
			req.getServletContext().setAttribute("user_name", admin.getUser_name());
			req.getServletContext().setAttribute("user", admin);
		}else{
			Buser buser = userService.getBuser(user_ID);
			BeanUtils.populate(buser, req.getParameterMap());
			buser.setUser_name(req.getParameter("user_name"));
			buser.setUser_ID(user_ID);
			userService.UpdateBuser(buser);
			req.getServletContext().setAttribute("user_name", buser.getUser_name());
			req.getServletContext().setAttribute("user", buser);
		}
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
	
	@RequestMapping("cancel.action")
	public void cancel(HttpServletRequest req, HttpServletResponse res,String user_name) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		User User =(User) req.getServletContext().getAttribute("user");
		if(User instanceof Admin)
		{
			 User user = (User)userService.user(user_name);
			if(user instanceof Cuser)
			{
				Cuser cuser = userService.getCuser(user.getUser_ID());
				userService.DeleteCuser(cuser);
			}else if(user instanceof Admin)
			{
				Admin admin = userService.getAdmin(user.getUser_ID());
				userService.DeleteAdmin(admin);
			}else{
				Buser buser = userService.getBuser(user.getUser_ID());
				userService.DeleteBuser(buser);
			}
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}else{
			req.getRequestDispatcher("error.jsp").forward(req, res);
		}
	}
}
