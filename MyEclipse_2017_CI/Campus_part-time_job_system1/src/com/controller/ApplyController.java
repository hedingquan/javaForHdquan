package com.controller;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Service.ApplyService;
import com.Service.UserService;
import com.Service.WorkService;
import com.pojo.Apply;
import com.pojo.Cuser;
import com.pojo.User;
import com.pojo.Work; 

@Controller
public class ApplyController {

	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WorkService workService;

	@RequestMapping("getAllApply.action")
	public void getAllApply(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		List<Apply> allApply = applyService.getAllApply();
		if(allApply!=null&&allApply.size()>0)
		{
			for(Apply apply:allApply)
			{
				if(userService.getAdmin(apply.getUser_id())!=null)
				{
					apply.setUser_id(userService.getAdmin(apply.getUser_id()).getUser_name());
				}else if(userService.getBuser(apply.getUser_id())!=null)
				{
					apply.setUser_id(userService.getBuser(apply.getUser_id()).getUser_name());
				}else{
					apply.setUser_id(userService.getCuser(apply.getUser_id()).getUser_name());
				}
			}
		}
		req.setAttribute("apply", allApply);
		req.getRequestDispatcher("delete_apply.jsp").forward(req, res);
	}
	
	@RequestMapping("getApply.action")
	public void getApply(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		User user = (User)userService.user((String)req.getServletContext().getAttribute("user_name"));
		List<Apply> toBeAuditedApply=new ArrayList<Apply>();
		for(Work work:workService.MyWork(user.getUser_ID()))
		{			
			toBeAuditedApply.addAll(applyService.getToBeAuditedApply(String.valueOf(work.getWork_id()))); 
		}
		if(toBeAuditedApply!=null&&toBeAuditedApply.size()>0)
		{
			for(Apply apply:toBeAuditedApply)
			{
				apply.setWork_id(workService.getWork(apply.getWork_id()).getWork_title());
				if(userService.getAdmin(apply.getUser_id())!=null)
				{
					apply.setUser_id(userService.getAdmin(apply.getUser_id()).getUser_name());
				}else if(userService.getBuser(apply.getUser_id())!=null)
				{
					apply.setUser_id(userService.getBuser(apply.getUser_id()).getUser_name());
				}else{
					apply.setUser_id(userService.getCuser(apply.getUser_id()).getUser_name());
				}
			}
		}
		req.setAttribute("apply", toBeAuditedApply);
		req.getRequestDispatcher("get_apply_bin.jsp").forward(req, res);
	}
	
	@RequestMapping("getMyApply.action")
	public void getMyApply(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		User user = (User)userService.user((String)req.getServletContext().getAttribute("user_name"));
		List<Apply> MyApply = applyService.getMyApply(user.getUser_ID());
		for(Apply apply:MyApply)
		{
			apply.setWork_id(workService.getWork(apply.getWork_id()).getWork_title());;
		}
		req.setAttribute("apply", MyApply);
		req.getRequestDispatcher("get_apply_stu.jsp").forward(req, res);
	}
	
	@RequestMapping("delete_apply.action")
	public void delete_apply(HttpServletRequest req, HttpServletResponse res,String applyids) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
			applyService.DeleteApply(applyService.getApply(applyids));
			req.getRequestDispatcher("add_apply.jsp").forward(req, res);
	}
	
	@RequestMapping("add_apply.action")
	public void add_apply(HttpServletRequest req, HttpServletResponse res,String work_id) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		String user_name = (String)req.getServletContext().getAttribute("user_name");
		User user = (User)userService.user(user_name);
		Work work = workService.getWork(work_id);
		Integer usertotal=0;
		if(work.getWork_content()!=null&&!",".equals(work.getWork_content())&&!"".equals(work.getWork_content()))
		{
			for(String username:work.getWork_content().split(","))
			{
				usertotal++;
			}
		}
		if(usertotal<work.getWork_number())
		{
			if(user instanceof Cuser)
			{
			Apply apply=new Apply();
			apply.setWork_id(work_id);
			apply.setUser_id(user.getUser_ID());
			apply.setApply_state("ToBeAudited");
			Apply addApply = applyService.AddApply(apply);
			/*req.setAttribute("work", work);
			req.getRequestDispatcher("get_work_start.jsp").forward(req, res);*/
			req.setAttribute("Ation", "提示:申请成功");
			req.getRequestDispatcher("work.jsp").forward(req, res);
			if("".equals(work.getWork_content())||work.getWork_content()==null)
			{
				work.setWork_content(user_name);
			}else{				
				work.setWork_content(work.getWork_content()+","+user_name);
			}
			workService.UpdateWork(work);
			}else{
				req.getRequestDispatcher("NoCuserError.jsp").forward(req, res);
			}
		}else{
			req.setAttribute("Ation", "申请名额满提示:不能申请");
			req.getRequestDispatcher("work.jsp").forward(req, res);
		}
	
	}
}
