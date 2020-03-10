package com.hdquan.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hdquan.pojo.ActiveUser;

@Controller
public class OnLineController {
	
	@Autowired
	private SessionDAO sessionDAO;
	
	@RequestMapping("onLine.action")
	public void OnLine(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		 response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		 List<Object> list=new ArrayList<Object>();
			try {
				Collection<Session> sessions = sessionDAO.getActiveSessions();
				for(Session session:sessions){
					ActiveUser user=new ActiveUser();
					user.setId(session.getId()); 
					user.setStartTimestamp(session.getStartTimestamp());
					user.setHost(session.getHost());
					user.setLastAccessTime(session.getLastAccessTime());
					user.setTimeout(session.getTimeout());
					Object use = session.getAttribute(DefaultWebSubjectContext.PRINCIPALS_SESSION_KEY);
					user.setUse(use); 	
					request.setAttribute("name", use);
					list.add(user);
				/*		System.out.println("登录ip:"+host);

		System.out.println("登录用户"+session.getAttribute(DefaultWebSubjectContext.PRINCIPALS_SESSION_KEY));

		System.out.println("最后操作日期:"+lastAccessTime);
*/

				}
			} catch (Exception e) {
			
			}
			 request.setAttribute("list", list);
			request.getRequestDispatcher("/OnLine.jsp").forward(request, response);
	}
 }
