package com.hdquan.shiro.realm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdquan.MD5.CaptchaToken;
import com.hdquan.MD5.IPUtil;
import com.hdquan.pojo.Adress;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.ProvisionalAuthorization;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.pojo.UserGroup;
import com.hdquan.service.AdressService;
import com.hdquan.service.ProvisionalAuthorizationService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserService;



public class CustomRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	@Autowired
	private AdressService adressService;
	
	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ProvisionalAuthorizationService provisionalAuthorizationService;
	
	private Logger log = Logger.getLogger(CustomRealm.class);
	
	public void setName(String name) {
		super.setName("CustomRealm");
	}
	
		@Override
		public boolean supports(AuthenticationToken token) {
			return token instanceof UsernamePasswordToken;
		}
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("进入角色授权");
		String userName = (String) getAvailablePrincipal(principalCollection);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		User user = userService.queryByNameAndPwd(userName);
		
			 String userCode = (String)SecurityUtils.getSubject().getPrincipal();
	    	ServletContext servletContext = ((WebSubject)SecurityUtils.getSubject()).getServletRequest().getServletContext();
	    	Integer Departmentvalue=null;
	    	Integer UserGroupvalue=null;
			Set<String> roleIds=new HashSet<String>();//不重复的数据
			List<Role> departmentRoles=null;
			List<Role> userGroupRoles=null;
			List<Role> AutoUserPermission =new ArrayList<>();//可以重复的数据
	    		if(user.getUserGroup()!=null){	    			
	    			UserGroupvalue= (Integer)servletContext.getAttribute("UserGroup-"+user.getUserGroup().getUsGId()+"HasUserLogin");
	    			userGroupRoles = roleService.getUserGroupRoles(String.valueOf(user.getUserGroup().getUsGId()));
	    		}
	    		if(user.getDepartment()!=null){	    			
	    			Departmentvalue= (Integer)servletContext.getAttribute("Department-"+user.getDepartment().getNumber1()+"HasUserLogin");
	    			departmentRoles = roleService.getDepartmentRoles(user.getDepartment().getNumber1());
	    		}
	    		if((null==Departmentvalue||null==UserGroupvalue||Departmentvalue==1||UserGroupvalue==1)){
					 //自动授权管理之授权部门或用户组没人的角色开启
	    			if(null==Departmentvalue||Departmentvalue==1){
	    				if(departmentRoles!=null)
	    				{
	    				for(Role role:departmentRoles){
					    	if(role.getPermission()!=null){		    	
					    		AutoUserPermission.add(role);
					    		roleIds.add(role.getRoleId());
					    	}
	    				}
	    				}
	    			}
	    			if(null==UserGroupvalue||UserGroupvalue==1){
	    				if(userGroupRoles!=null)
	    				{
		    				for(Role role:userGroupRoles){
						    	if(role.getPermission()!=null){		    	
						    		AutoUserPermission.add(role);
						    		roleIds.add(role.getRoleId());
						    	}
		    				}
	    				}
	    			}
					Set<String> handleMappings=new HashSet<String>();
	    			if(AutoUserPermission!=null){
						for(int o=0;o<AutoUserPermission.size();o++){
							for(Permission newpermission:AutoUserPermission.get(o).getPermission())
							{
								handleMappings.add(newpermission.getName());
							}
						}
					}
				info.setStringPermissions(handleMappings);
				info.setRoles(roleIds);
				}
		
	
				if(user.getRoles().size() > 0)
				{
					for (Role AutoRole : user.getRoles())
					{
					if("false".equals(AutoRole.getHasUserLogin())){
						 //自动授权管理之授权请求角色开启
					    	if(AutoRole.getRequestRole()!=null&&!"".equals(AutoRole.getRequestRole())){		    	
					    		Role newRole=roleService.getRole(AutoRole.getRequestRole());
					    		if(newRole!=null){
						    		AutoUserPermission.add(newRole);
						    		roleIds.add(newRole.getRoleId());
					    		}
					    	}
						}
					AutoUserPermission.add(AutoRole);
					roleIds.add(AutoRole.getRoleId());
					}
				}
				
				//临时授权
				ProvisionalAuthorization provisionalAuthorization = provisionalAuthorizationService.getRole(userName);
				if(provisionalAuthorization!=null){
					if(provisionalAuthorization.getRecoveryTime().compareTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))>0)
					{
					List<Role> roleId = roleService.getRoleId(provisionalAuthorization.getRoleid());
					if(roleId!=null){		
						for(Role role:roleId)
						{
							AutoUserPermission.add(role);
							roleIds.add(role.getRoleId());
						}
					}
					}
				}
				
						try {
							boolean exists=false;
							String hostAddress = InetAddress.getLocalHost().getHostAddress();
							List<Adress> adressByroles = adressService.getAdressByroles(userName);
							if(adressByroles.size()>0){	
								//地址管理判断
							for(Adress Othernewadress:adressByroles)
								{
								exists=IPUtil.ipExistsInRange(hostAddress,Othernewadress.getIPStart()+"-"+Othernewadress.getIPEnd());
									 if(!exists) //当有角色——地址不在自己的范围内时
										{
											for(Role limitRole:Othernewadress.getRoles())
											{
												for(int i=0;i<AutoUserPermission.size();i++)
												{
													if(String.valueOf(AutoUserPermission.get(i).getNumber()).equals(String.valueOf(limitRole.getNumber())))
													{														
														AutoUserPermission.remove(limitRole);
														roleIds.remove(limitRole);
													}
												}
											}
										}
								}
							}
							if(AutoUserPermission!=null){
								Set<String> handleMappings=new HashSet<String>();
								for(int o=0;o<AutoUserPermission.size();o++){
									for(Permission newpermission:AutoUserPermission.get(o).getPermission())
									{
										handleMappings.add(newpermission.getName());	
										info.addStringPermissions(handleMappings);
										info.addRoles(roleIds);
									}
								}
							}
						} catch (UnknownHostException e) {
						}

		
		//用户排他属性和用户组排他属性
		Set<String> roles = info.getRoles();
		Set<String> PropertiesRoleIds=new HashSet<String>();
		ArrayList UserExclusiveRoleList = (ArrayList)servletContext.getAttribute("UserExclusive");
		if(UserExclusiveRoleList!=null){
			for(int i=0;i<UserExclusiveRoleList.size();i++){
				for(String role:roles)
				{
					if(!role.toString().equals((String)UserExclusiveRoleList.get(i).toString()))
					{
						PropertiesRoleIds.add(role);
					}else{
						String UsingUsername =(String)servletContext.getAttribute("User_Rejection_attribute"+role);
							if(UsingUsername!=null&&(UsingUsername.toString()).equals(userCode)){
								PropertiesRoleIds.add(role);
							}else{
								MDC.put("User_Rejection_attribute","当前使用用户排他属性用户名:"+UsingUsername);
								log.info("当前有人使用排他属性，您访问权限被阻止了，用户为："+UsingUsername.toString());
							}
						}
				}
			}
		info.setRoles(PropertiesRoleIds);//不设置权限，只要角色和权限其中一个不满足则代表无权限
		}
		Set<String> UserGroupPropertiesRoleIds=new HashSet<String>();
		Set<String> UserGroupExclusiveRole = info.getRoles();
		ArrayList UserGroupExclusiveRoleList = (ArrayList)servletContext.getAttribute("UserGroupExclusive");
		if(UserGroupExclusiveRoleList!=null){
			for(int i=0;i<UserGroupExclusiveRoleList.size();i++){
				for(String role:UserGroupExclusiveRole)
				{
					if(!role.toString().equals((String)UserGroupExclusiveRoleList.get(i).toString()))
					{
						UserGroupPropertiesRoleIds.add(role);
					}else{
						String UsingUsername =(String)servletContext.getAttribute("UserGroupExclusiveProperties"+role);
							if(UsingUsername!=null&&(UsingUsername.toString()).equals(userCode)){
								UserGroupPropertiesRoleIds.add(role);
							}else{
								MDC.put("UserGroupExclusiveProperties","当前使用用户排他属性用户名:"+UsingUsername);
								log.info("当前有人使用排他属性，您访问权限被阻止了，用户为："+UsingUsername.toString());
							}
						}
				}
			}
		info.setRoles(UserGroupPropertiesRoleIds);//不设置权限，只要角色和权限其中一个不满足则代表无权限
		}
		
		
		
		//拒绝属性
		Set<String> Hasroles=info.getRoles();
		if(user.getDepartment()!=null&&user.getUserGroup()!=null)
		{
			if(user.getDepartment().getRoles()!=null&&user.getUserGroup().getRoles()!=null){
			Set<String> Rejection_attributeRoleIds=new HashSet<String>();
				for(Role role:user.getDepartment().getRoles())
					for(Role OtherRole:user.getUserGroup().getRoles())
					{
						if(role.getNumber()==OtherRole.getNumber())
						{
							for(Permission permission:role.getPermission())
							if(permission.getRejection_attribute())
							{
								for(String OneRole:Hasroles)
								{
									if(!OneRole.toString().equals(role.getNumber()))
									{
										Rejection_attributeRoleIds.add(OneRole);
									}else{
										MDC.put("ExclusiveProperties","当前用户组和部门发生冲突");
										log.info("当前用户组和部门发生冲突，您访问权限被阻止了");
									}
								}
							} 
						}
					}
				if(Rejection_attributeRoleIds.size()>0)
				{					
					info.setRoles(Rejection_attributeRoleIds);
				}
			}
		}
		//强制属性--不会写，见谅！
		
		return info;
	}
	
	
	
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
	    CaptchaToken captchaToken = (CaptchaToken) token;
	    String userCode = (String)captchaToken.getPrincipal();
	    User user = userService.queryByNameAndPwd(userCode);
	    if(user==null)
	    {
	    	return null;
	    }
	    Collection<Session> activeSessions = sessionDAO.getActiveSessions();
    	ServletContext servletContext = ((WebSubject)SecurityUtils.getSubject()).getServletRequest().getServletContext();
    	servletContext.setAttribute("thisUser", userCode);
		Set<String> roleIds=new HashSet<String>();
		if(user.getUserGroup()!=null)
		{
			servletContext.setAttribute("UserGroup-"+user.getUserGroup().getUsGId()+"HasUserLogin", 1);  			
		}if(user.getDepartment()!=null)
		{
			servletContext.setAttribute("Department-"+user.getDepartment().getNumber1()+"HasUserLogin", 1); 				
		}
	    for(Session session:activeSessions){
	    	Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
	    	if(userCode.equals(String.valueOf(attribute))) 
	    	{
	    	session.setTimeout(0);//设置session立即失效，即将其踢出系统
	    	break;
	    	}
	    	String name=String.valueOf(attribute);
	    	if(name!=null&&!"null".equals(name)){
	    	User Onlineuser = userService.queryByNameAndPwd(name);
	    	//自动授权管理之登录
		    if(Onlineuser.getDepartment()!=null||Onlineuser.getUserGroup()!=null){	   
		    	if(Onlineuser.getUserGroup()!=null){
		    		Integer UserGroupCount =(Integer) servletContext.getAttribute("UserGroup-"+Onlineuser.getUserGroup().getUsGId()+"HasUserLogin");//有用户组用户登录:人数	    				
		    		if(UserGroupCount==null||UserGroupCount==0||UserGroupCount==1)
		    		{
		    			UserGroupCount=1;
		    		}else{
		    		UserGroupCount++;//在线用户组人数+1
		    		}
		    		if(user.getUserGroup()!=null&&String.valueOf(user.getUserGroup().getUsGId()).equals(String.valueOf(Onlineuser.getUserGroup().getUsGId())))
		    		 {
		    			UserGroupCount++;
		    			Set<Role> roles = Onlineuser.getUserGroup().getRoles();
		    			 roles.addAll(Onlineuser.getDepartment().getRoles());
		    			if(roles!=null){
		    				for(Role role:roles)
				    		{		 
		    					roleIds.add(role.getRoleId());
				    		}
									   	}
		    		 }else if(user.getUserGroup()!=null)	
		    		 {
		    			 Integer UserGroupCount1 =(Integer) servletContext.getAttribute("UserGroup-"+user.getUserGroup().getUsGId()+"HasUserLogin");//有用户组用户登录:人数	    				
				    		if(UserGroupCount1==null||UserGroupCount1==0||UserGroupCount1==1)
				    		{
				    			UserGroupCount1=1;
				    		}else{
				    			UserGroupCount1++;//在线用户组人数+1
				    		}
		    		 }
		    		servletContext.setAttribute("UserGroup-"+Onlineuser.getUserGroup().getUsGId()+"HasUserLogin", UserGroupCount);//有用户组用户登录:人数	    			
									    		}
		    	 if(Onlineuser.getDepartment()!=null){	
		    		Integer DepartmentCount = (Integer)servletContext.getAttribute("Department-"+Onlineuser.getDepartment().getNumber1()+"HasUserLogin");//有部门用户登录:人数	    			
		    		if(DepartmentCount==null||DepartmentCount==0||DepartmentCount==1)
		    		{
		    			DepartmentCount=1;
		    		}else{
		    		DepartmentCount++;//在线部门人数+1
		    		}
		    		if(user.getDepartment()!=null&&String.valueOf(user.getDepartment().getNumber1()).equals(String.valueOf(Onlineuser.getDepartment().getNumber1())))
	    			 {
		    			DepartmentCount++;
		    			Set<Role> roles = Onlineuser.getDepartment().getRoles();
 	    			if(roles!=null){
 	    				for(Role role:roles)
 			    		{	
 	    					roleIds.add(role.getRoleId());
 			    		}
 			    		}
	    			 }else if(user.getDepartment()!=null)
	    			 {
	    					Integer DepartmentCount1 = (Integer)servletContext.getAttribute("Department-"+user.getDepartment().getNumber1()+"HasUserLogin");//有部门用户登录:人数	    			
	    		    		if(DepartmentCount1==null||DepartmentCount1==0||DepartmentCount==1)
	    		    		{
	    		    			DepartmentCount1=1;
	    		    		}else{
	    		    			DepartmentCount1++;//在线部门人数+1
	    		    		}
	    			 }
		    		servletContext.setAttribute("Department-"+Onlineuser.getDepartment().getNumber1()+"HasUserLogin", DepartmentCount);//有部门用户登录:人数	    			
		    	} 
		    }
	    	}
	    }
	    Integer DepartmentCount=0;
	    Integer UserGroupCount=0;
	    if(user.getDepartment()!=null)
	    {	    	
	    	DepartmentCount= (Integer)servletContext.getAttribute("Department-"+user.getDepartment().getNumber1()+"HasUserLogin");
	    }
	    if(user.getUserGroup()!=null)
	    {	    	
	    	UserGroupCount=(Integer)servletContext.getAttribute("UserGroup-"+user.getUserGroup().getUsGId()+"HasUserLogin");
	    }
	    if(1==DepartmentCount||1==UserGroupCount)
	    {
	    	for(Role role:user.getRoles())
	    	{
	    		role.setHasUserLogin("false");
				roleService.updateRole(role);
	    	}
	    }
	    //基础角色更新
	    for(String roleId:roleIds)
	    {
	    	List<Role> RoleId = roleService.getRoleId(roleId);
	    	for(Role role:RoleId)
	    	{
	    	role.setHasUserLogin("true");
			roleService.updateRole(role);
	    	}
	    }	
	 
	    if (captchaToken.getCaptchaCode() == null || "".equals(captchaToken.getCaptchaCode())) {
	        throw new AuthenticationException();
	    }
	
	    if (!captchaToken.getCaptchaCode().equals((String) SecurityUtils.getSubject().getSession().getAttribute("KAPTCHA_SESSION_KEY"))) {
	        throw new AuthenticationException();
	    }
	   
		return new SimpleAuthenticationInfo(userCode, user.getUsername(), ByteSource.Util.bytes("hdquan"), this.getName());
	}
		public void clearCache()
		{
			super.clearCache(SecurityUtils.getSubject().getPrincipals());
		}
}
