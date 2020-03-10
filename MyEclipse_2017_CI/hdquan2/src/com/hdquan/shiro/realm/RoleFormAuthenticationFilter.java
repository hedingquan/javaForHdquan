package com.hdquan.shiro.realm;


import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class RoleFormAuthenticationFilter extends AccessControlFilter{

	@Autowired
	private SessionDAO sessionDAO;
	
	 public static final String DEFAULT_LOGIN_URL = "/role.action";
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		
		Subject subject = getSubject(request, response);
	        if (subject.getPrincipal() == null) {// 表示没有登录，重定向到登录页面
	            saveRequest(request);
	            WebUtils.issueRedirect(request, response, "/login.action");
	        }else
	        {
	        	Object roleId = request.getParameter("roleId");
	        	ServletContext servletContext = request.getServletContext();
	        	String applicationRoleId = servletContext.getInitParameter("Using_Role");
	        	if(servletContext.getAttribute("Using_Role")==null&&applicationRoleId.equals("0"))
	        	{
	        		servletContext.setAttribute("Using_Role", 1);
	        	}
	        	else if(servletContext.getAttribute("Using_Role")!=null)
	        	{
	        		if(servletContext.getAttribute("Using_Role").equals("0"))
        			{
	        		servletContext.setAttribute("Using_Role", 1);
        			}
	        	}else
	        	{
	        		//已经有人拿到了角色
	        		 WebUtils.issueRedirect(request, response, "/error.jsp");
	        		 WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
	        		 return false;
	        	}
	        }
    		return true;
	}
}
