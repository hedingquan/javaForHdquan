package com.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
public class WorkController {

	@Autowired
	private WorkService workService;
	
	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("add_work_bus.action")
	public void add_work_bus(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		Work work=new Work();
		BeanUtils.populate(work, req.getParameterMap());
		work.setUser_id(((User)req.getServletContext().getAttribute("user")).getUser_ID());
		work.setWork_state(-1);
		 Work addWork = workService.AddWork(work);
		req.getServletContext().setAttribute("addWork", addWork);
		req.getRequestDispatcher("work.jsp").forward(req, res);
	}
	
	@RequestMapping("delete_work.action")
	public void delete_work(HttpServletRequest req, HttpServletResponse res,String work_id) throws IOException, ServletException
	{
		workService.DeleteWork(workService.getWork(work_id));
		req.getRequestDispatcher("work.jsp").forward(req, res);
	}
	
	@RequestMapping("delete_work_stu.action")
	public void delete_work_stu(HttpServletRequest req, HttpServletResponse res,String name,String work_id) throws IOException, ServletException
	{
		String Work_content="";
		Work work = workService.getWork(work_id);
		for(String OneTolast:work.getWork_content().split(","))
		{
			if(!name.equals(OneTolast))
			{
				Work_content+=OneTolast+",";
			}
		}
		work.setWork_content(Work_content);
		workService.UpdateWork(work);
		req.getRequestDispatcher("get_work_ifmormation_self.action").forward(req, res);
	}
	
	@RequestMapping("Search_work_state.action")
	public void Search_work_state(HttpServletRequest req, HttpServletResponse res,String work_title) throws IOException, ServletException
	{
		Work work=null;
		Work addWork = workService.getWorkBywork_title(work_title);
		if(addWork!=null)
		{ 
			work= workService.getWork(String.valueOf(addWork.getWork_id()));
				if(work.getWork_state()!=null||"-1".equals(work.getWork_state()))
			{
				req.setAttribute("Ready_update_work", addWork);
				req.getRequestDispatcher("update_work_content.jsp").forward(req, res);
			}
		}else
		{
			List<Work> allWork = workService.AllWork();
			List<Cuser> applyUsers=new ArrayList<Cuser>();
			List<Apply> applyUser = applyService.getApplyUser(String.valueOf(allWork.get(0).getWork_id()));
			for(Apply appaly:applyUser)
			{
				applyUsers.add(userService.getCuser(appaly.getUser_id()));
			}
			req.setAttribute("apply", applyUsers);
			req.setAttribute("applystate", applyUser.get(0).getApply_state());
			req.setAttribute("work", allWork.get(0));
			req.getRequestDispatcher("add_work_stu.jsp").forward(req, res);
		}
	}
	
	@RequestMapping("update_work_content.action")
	public void update_work_content(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		Work addWork = (Work)req.getServletContext().getAttribute("addWork");
		Work work = workService.getWork(String.valueOf(addWork.getWork_id()));
		if(work!=null)
		{
			BeanUtils.populate(work, req.getParameterMap());
			workService.UpdateWork(work);
			req.getRequestDispatcher("work.jsp").forward(req, res);
		}
	}
	
	@RequestMapping("get_work_iformation.action")
	public void get_work_iformation(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		List<Work> allWork = workService.AllWork();
		for(Work work:allWork)
		{
			if(userService.getAdmin(work.getUser_id())!=null)
			{
				work.setUser_id(userService.getAdmin(work.getUser_id()).getUser_name());
			}else if(userService.getBuser(work.getUser_id())!=null)
			{
				work.setUser_id(userService.getBuser(work.getUser_id()).getUser_name());
			}else{
				work.setUser_id(userService.getCuser(work.getUser_id()).getUser_name());
			}
		}
		req.setAttribute("work", allWork);
		req.getRequestDispatcher("get_work_iformation.jsp").forward(req, res);
	}
	
	@RequestMapping("get_work_ifmormation_self.action")
	public void get_work_ifmormation_self(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		String user_name = (String)req.getServletContext().getAttribute("user_name");
		List<Work> myWork = workService.MyWork(((User)userService.user(user_name)).getUser_ID());
		req.setAttribute("work", myWork);
		req.getRequestDispatcher("get_work_ifmormation_self.jsp").forward(req, res);
	}
	
	@RequestMapping("get_work_ifmormation_self2.action")
	public void get_work_ifmormation_self2(HttpServletRequest req, HttpServletResponse res,String a) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		String user_name = (String)req.getServletContext().getAttribute("user_name");
		List<Work> myWork = workService.MyWork(((User)userService.user(user_name)).getUser_ID());
		req.setAttribute("work", myWork);
		if("1".equals(a))
		{			
			req.getRequestDispatcher("get_work_ifmormation_self2.jsp").forward(req, res);
		}else{
			req.getRequestDispatcher("get_work_ifmormation_self3.jsp").forward(req, res);
		}
	}
	
	@RequestMapping("get_work_start.action")
	public void get_work_start(HttpServletRequest req, HttpServletResponse res,String work_id) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		Work work = workService.getWork(work_id);
		work.setWork_state(1);
		workService.UpdateWork(work);
		
		String work_content = work.getWork_content();
		if(work_content!=null&&!"".equals(work_content)&&!",".equals(work_content))
		for(String username:work_content.split(","))
		{
			List<Apply> myApply = applyService.getMyApply(((User)userService.user(username)).getUser_ID());
			for(Apply apply:myApply)
			{
				if(apply.getWork_id()!=null&&apply.getWork_id().equals(work_id))
				{
					apply.setApply_state("Working");
					applyService.UpdateApply(apply);
				}
			}
		}
		req.getRequestDispatcher("work.jsp").forward(req, res);
	}
	@RequestMapping("get_work_end.action")
	public void get_work_end(HttpServletRequest req, HttpServletResponse res,String work_id) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		Work work = workService.getWork(work_id);
		work.setWork_state(0);
		workService.UpdateWork(work);
	
		String work_content = work.getWork_content();
		if(work_content!=null&&!"".equals(work_content)&&!",".equals(work_content))
		for(String username:work_content.split(","))
		{
			List<Apply> myApply = applyService.getMyApply(((User)userService.user(username)).getUser_ID());
			for(Apply apply:myApply)
			{
				if(apply.getWork_id()!=null&&apply.getWork_id().equals(work_id))
				{
					apply.setApply_state("End_Working");
					applyService.UpdateApply(apply);
				}
			}
		}
		req.getRequestDispatcher("work.jsp").forward(req, res);
	}
	
	@RequestMapping("add_work_stu.action")
	public void add_work_stu(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, IllegalAccessException, InvocationTargetException
	{
		List<Cuser> applyUsers=new ArrayList<Cuser>();
		String user_name = (String)req.getServletContext().getAttribute("user_name");
		List<Apply> myApply = applyService.getMyApply(((User)userService.user(user_name)).getUser_ID());
		for(Apply apply:myApply)
		{
			applyUsers.add(userService.getCuser(apply.getUser_id()));
		}
		req.setAttribute("apply", applyUsers);
		req.setAttribute("applystate", "passed");
		req.getRequestDispatcher("add_work_stu.jsp").forward(req, res);
	}
}
