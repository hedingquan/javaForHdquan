package com.hdquan.shiro.realm;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;


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
		ServletContext servletContext = request.getServletContext();
		List  UserExclusiveRoleList= (ArrayList)servletContext.getAttribute("UserExclusive");
		List  ApplicationUserExclusiveRoleList=new ArrayList();
		if(UserExclusiveRoleList==null){
			UserExclusiveRoleList=ApplicationUserExclusiveRoleList;
		}
		if(parameter!=null){
		 for(Session session:sessionDAO.getActiveSessions()){
			 if(String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))!=null&&!"null".equals(String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))))
				 {
				 if(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals(servletContext.getAttribute("User_Rejection_attribute"+parameter))
						 ||servletContext.getAttribute("User_Rejection_attribute"+parameter)==null) //判断上一个该请求的用户是否在线--不在线
			    	{	
					 		if(SecurityUtils.getSubject().hasRole(parameter))
							{		    	
					 			if(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals((String)SecurityUtils.getSubject().getPrincipal()))
					 			{	
					 				MDC.put("User_Rejection_attribute",(String)SecurityUtils.getSubject().getPrincipal());
							    			 log.info("使用用户排他性属性成功！");
							    			Object object= MDC.get("User_Rejection_attribute");
							    			servletContext.setAttribute("User_Rejection_attribute"+parameter, object);//排他属性角色parameter：
							    			UserExclusiveRoleList.add(parameter);
							    			servletContext.setAttribute("UserExclusive", UserExclusiveRoleList);
							    			return true;
					 			}
							  }else
							  {
									MDC.put("User_Rejection_attribute","当前用户名:"+(String)SecurityUtils.getSubject().getPrincipal());
					    			 log.info("对不起，您没有该角色权限");
					    			 return false;
							  }
					}else{
						MDC.put("User_Rejection_attribute","当前使用用户排他属性用户名:"+servletContext.getAttribute("User_Rejection_attribute"+parameter));
		    			 log.info("对不起，当前有用户使用用户排他属性");	
		    			 return false;
					    	}
				}
		 }
		 if(servletContext.getAttribute("User_Rejection_attribute"+parameter)!=null){
		 MDC.put("User_Rejection_attribute",servletContext.getAttribute("User_Rejection_attribute"+parameter));
		 log.info("使用用户排他性属性失败！,当前使用用户为"+servletContext.getAttribute("User_Rejection_attribute"+parameter).toString());
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



