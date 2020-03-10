package com.hdquan.shiro.realm;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserService;

public class logoutFilter extends LogoutFilter{

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 String username = (String) this.getSubject(request, response).getPrincipal();
		 try {
			 if(username!=null){
			User user = userService.queryByNameAndPwd(username);
			  if(user==null)
			    {
			    }else{
			    	 //自动授权管理之退出
				    if(user.getDepartment()!=null||user.getUserGroup()!=null){	    	
				    	ServletContext servletContext = request.getServletContext();
				    	if(user.getDepartment()!=null){
				    		Object value =servletContext.getAttribute("Department-"+"HasUserLogin");
				    		int Intvalue = Integer.parseInt(String.valueOf(value));
				    		Intvalue--;
				    		if(Intvalue<=0){
				    			Intvalue=0;//该部门没有用户登录
				    			Set<Role> roles = user.getRoles();
				    			for(Role role:roles){
				    				String requestRole = role.getRequestRole();
				    				if(requestRole!=null){
				    					Role role2 = roleService.getRole(String.valueOf(role.getNumber()));
				    					role2.setHasUserLogin("false");
				    					roleService.updateRole(role2);
				    				}
				    			}
				    		}
				    		servletContext.setAttribute("Department-"+"HasUserLogin", Intvalue);//有部门用户登录:人数	    		
				    	}
				    	if(user.getUserGroup()!=null){
				    		Object value =servletContext.getAttribute("UserGroup-"+"HasUserLogin");
				    		int Intvalue = Integer.parseInt(String.valueOf(value));
				    		Intvalue--;
				    		if(Intvalue<=0){
				    			Intvalue=0;//该用户组没有用户登录
				    			Set<Role> roles = user.getRoles();
				    			for(Role role:roles){
				    				String requestRole = role.getRequestRole();
				    				if(requestRole!=null){
				    					Role role2 = roleService.getRole(String.valueOf(role.getNumber()));
				    					role2.setHasUserLogin("false");
				    					roleService.updateRole(role2);
				    				}
				    			}
				    		}
				    		servletContext.setAttribute("UserGroup-"+"HasUserLogin", Intvalue);//有用户组用户登录:人数	    		
				    	}
				    }
			    }
		} 
			 }catch (Exception e) {
		}
		return super.preHandle(request, response);
	}
}
