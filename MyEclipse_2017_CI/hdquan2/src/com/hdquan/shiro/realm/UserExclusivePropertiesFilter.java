package com.hdquan.shiro.realm;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public class UserExclusivePropertiesFilter extends AccessControlFilter{

	@Autowired
	private SessionDAO sessionDAO;
	
	 public static final String DEFAULT_LOGIN_URL = "/**";
	
		private Logger log = Logger.getLogger(UserExclusivePropertiesFilter.class);
 
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		

		String parameter = request.getParameter("User_Rejection_attribute");//用户排他性属性
		Subject subject = SecurityUtils.getSubject();
		ServletContext servletContext = request.getServletContext();
		List  UserExclusiveRoleList= (ArrayList)servletContext.getAttribute("UserExclusive");
		List  ApplicationUserExclusiveRoleList=new ArrayList();
		if(UserExclusiveRoleList==null){
			UserExclusiveRoleList=ApplicationUserExclusiveRoleList;
		}
		Object username = servletContext.getAttribute("User_Rejection_attribute"+parameter);
	 String userCode = (String)SecurityUtils.getSubject().getPrincipal();
	 Collection<Session> activeSessions;
	 activeSessions = sessionDAO.getActiveSessions();
		if(parameter!=null){
		 for(Session session:activeSessions){
			 if(String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))!=null&&!"null".equals(String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))))
				 {if(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals(username)||username==null) //判断上一个该请求的用户是否在线--不在线
			    	{	
							if(subject.hasRole(parameter))
							{	
							    	if(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals(userCode)) //判断当前用户是否在线-在线
							    	{		    	
							    			MDC.put("User_Rejection_attribute",userCode);
							    			 log.info("使用用户排他性属性成功！");
							    			Object object= MDC.get("User_Rejection_attribute");
							    			servletContext.setAttribute("User_Rejection_attribute"+parameter, object);//排他属性角色parameter：
							    			UserExclusiveRoleList.add(parameter);
							    			servletContext.setAttribute("UserExclusive", UserExclusiveRoleList);
							    			return true;
								    	}
							  }else
							  {
									MDC.put("User_Rejection_attribute","当前用户名:"+userCode);
					    			 log.info("对不起，您没有该角色权限");
					    			 return false;
							  }
					}else{
						MDC.put("User_Rejection_attribute","当前使用用户排他属性用户名:"+username);
		    			 log.info("对不起，当前有用户使用用户排他属性");	
		    			 return false;
					    	}
				}
		 }
		 if(username!=null){
		 MDC.put("User_Rejection_attribute",username);
		 log.info("使用用户排他性属性失败！,当前使用用户为"+username.toString());
		 return false;
		 }else{
			//没有人使用排他属性
				UserExclusiveRoleList.add(parameter);
    			servletContext.setAttribute("UserExclusive", UserExclusiveRoleList);
				return true;
		 }
}else{
			return true;
}
	}
}



