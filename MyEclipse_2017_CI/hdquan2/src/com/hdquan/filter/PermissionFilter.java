package com.hdquan.filter;

import java.io.IOException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@Service
public class PermissionFilter implements Filter{	
	@Autowired
	private SessionDAO sessionDAO;
	
	private Logger log = Logger.getLogger(PermissionFilter.class);

	  //需要排除的页面   
	private String excludedPages;       
	private String[] excludedPageArray;     
	  
	public void destroy() {     
	return;     
	}    
	
	 public static PermissionFilter permissionFilter;   // 关键2 添加该类的静态对象     
	
	 public PermissionFilter() {
	    }
	 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isExcludedPage = false;     
		for (String page : excludedPageArray) {//判断是否在过滤url之外     
		if(((HttpServletRequest)request).getServletPath().equals(page)){     
		isExcludedPage = true;     
		break;     
		}     
		}
		if (isExcludedPage) {//在过滤url之外     
			chain.doFilter(request, response);     
			}else{
		String parameter = request.getParameter("User_Rejection_attribute");//用户排他性属性
		if(parameter!=null){
			Subject subject = SecurityUtils.getSubject();
		String username =(String) MDC.get("User_Rejection_attribute");
		 String userCode = (String)SecurityUtils.getSubject().getPrincipal();
		 Collection<Session> activeSessions;
		try {
			activeSessions = sessionDAO.getActiveSessions();
			if(username==null){
				chain.doFilter(request, response);//空用户
			}
		 for(Session session:activeSessions){
		 if(!username.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) //判断上一个该请求的用户是否在线
	    	{	
			 	if(subject.hasRole(parameter)){	
				    	if(userCode.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) //判断当前用户是否在线
				    	{		    			
				    			chain.doFilter(request, response);
				    			MDC.put("User_Rejection_attribute",userCode);
				    			 log.info("使用用户排他性属性成功！");
					    	}
				    	break;
				    	}
			    	}
				}
		 MDC.put("User_Rejection_attribute",username);
		 log.info("使用用户排他性属性失败！,当前使用用户为"+username);
		} catch (Exception e) {
			if(username==null){
				chain.doFilter(request, response);
			}
		}
		 }
			}
	}
	// 初始化函数，获取需要排除在外的url    
	public void init(FilterConfig filterConfig) throws ServletException {     
	excludedPages = filterConfig.getInitParameter("excludedPages");     
	if (StringUtils.isNotEmpty(excludedPages)) {     
	excludedPageArray = excludedPages.split(",");     
	}
    //解决filter无法依赖注入的问题
    ServletContext sc = filterConfig.getServletContext();
    WebApplicationContext cxt =  WebApplicationContextUtils.getWebApplicationContext(sc);
    if (cxt != null && cxt.getBean("SessionDAO") != null && sessionDAO == null){
    	sessionDAO = (SessionDAO) cxt.getBean("SessionDAO");
    }
	return;     
	}   
}
