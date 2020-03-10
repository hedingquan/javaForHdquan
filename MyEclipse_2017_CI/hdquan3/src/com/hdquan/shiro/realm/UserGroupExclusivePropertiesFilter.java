package com.hdquan.shiro.realm;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdquan.pojo.User;
import com.hdquan.service.UserService;


public class UserGroupExclusivePropertiesFilter extends AccessControlFilter{

	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private UserService userService;
	
	 public static final String DEFAULT_LOGIN_URL = "/**";
	
		private Logger log = Logger.getLogger(UserGroupExclusivePropertiesFilter.class);
 
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		
		String parameter = request.getParameter("UserGroupExclusiveProperties");//用户组排他属性
		ServletContext servletContext = request.getServletContext();
		List  UserGroupExclusiveRoleList= (ArrayList)servletContext.getAttribute("UserGroupExclusive");
		List  ApplicationUserGroupExclusiveRoleList=new ArrayList();
		if(UserGroupExclusiveRoleList==null){
			UserGroupExclusiveRoleList=ApplicationUserGroupExclusiveRoleList;
		}
		if(parameter!=null){
		 for(Session session:sessionDAO.getActiveSessions()){
			 if(String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))!=null&&!"null".equals(String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))))
				 {if(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals(servletContext.getAttribute("UserGroupExclusiveProperties"+parameter))
						 ||servletContext.getAttribute("UserGroupExclusiveProperties"+parameter)==null) //判断上一个该请求的用户是否在线--不在线
			    	{	
					 if(SecurityUtils.getSubject().hasRole(parameter))
						{	
							 if(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).equals((String)SecurityUtils.getSubject().getPrincipal()))
							    	{		    	
							    			MDC.put("UserGroupExclusiveProperties", (String)SecurityUtils.getSubject().getPrincipal());
							    			 log.info("使用用户组排他属性成功！");
							    			Object object= MDC.get("UserGroupExclusiveProperties");
							    			servletContext.setAttribute("UserGroupExclusiveProperties"+parameter, object);//排他属性角色parameter：
							    			UserGroupExclusiveRoleList.add(parameter);
							    			servletContext.setAttribute("UserGroupExclusive", UserGroupExclusiveRoleList);
							    			return true;
								    	}
							  }else{
									MDC.put("UserGroupExclusiveProperties","当前用户名:"+ (String)SecurityUtils.getSubject().getPrincipal());
					    			 log.info("对不起，您没有该角色权限");
					    			 return false;
							  }
					 }else{
						String a= String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
						 User queryByNameAndPwd = userService.queryByNameAndPwd(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)));
						 User queryByNameAndPwd2 = userService.queryByNameAndPwd(String.valueOf(servletContext.getAttribute("UserGroupExclusiveProperties"+parameter)));
								 if(queryByNameAndPwd!=null&&queryByNameAndPwd2!=null&&queryByNameAndPwd.getUserGroup().getUsGId()==queryByNameAndPwd2.getUserGroup().getUsGId())	
								 {
									 MDC.put("UserGroupExclusiveProperties","当前使用用户组排他属性用户名:"+servletContext.getAttribute("UserGroupExclusiveProperties"+parameter));
						    			 log.info("对不起，当前有用户使用用户组排他属性");
						    			 return false;
								 }
					    	}
				}
		 }
		 if(servletContext.getAttribute("UserGroupExclusiveProperties"+parameter)!=null){
		 MDC.put("UserGroupExclusiveProperties",servletContext.getAttribute("UserGroupExclusiveProperties"+parameter));
		 log.info("使用用户组排他属性失败！,当前使用用户为"+servletContext.getAttribute("UserGroupExclusiveProperties"+parameter).toString());
		 return false;
		 }else{
			//没有人使用排他属性
			 UserGroupExclusiveRoleList.add(parameter);
    			servletContext.setAttribute("UserGroupExclusive", UserGroupExclusiveRoleList);
				return true;
		 }
}else{
	return true;
}
	}
}
