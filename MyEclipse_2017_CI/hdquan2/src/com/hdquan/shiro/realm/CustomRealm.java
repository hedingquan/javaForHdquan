package com.hdquan.shiro.realm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

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
import com.hdquan.service.DepartmentService;
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
		/*User  username = (User)principalCollection.getPrimaryPrincipal();
		List<String> permissions=new ArrayList<String>();
		
		SimpleAuthorizationInfo  authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(null);
		authorizationInfo.setStringPermissions(null);
		return authorizationInfo;*/
		
		System.out.println("进入角色授权");
		String userName = (String) getAvailablePrincipal(principalCollection);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		User user = userService.queryByNameAndPwd(userName);
		
	    Collection<Session> activeSessions = sessionDAO.getActiveSessions();
			ServletRequest request = ((WebSubject)SecurityUtils.getSubject()).getServletRequest();   
			 String userCode = (String)SecurityUtils.getSubject().getPrincipal();
	    	ServletContext servletContext = request.getServletContext();
	    	Integer Departmentvalue=null;
	    	Integer UserGroupvalue=null;
			Set<String> roleIds=new HashSet<String>();//不重复的数据
			List<Role> departmentRoles=null;
			List<Role> userGroupRoles=null;
			String requestRole = null;
			List<Role> AutoUserPermission =new ArrayList<>();//可以重复的数据
	    		if(user.getUserGroup()!=null){	    			
	    			UserGroupvalue= (Integer)servletContext.getAttribute("UserGroup-"+user.getUserGroup().getUsGId()+"HasUserLogin");
	    			userGroupRoles = roleService.getUserGroupRoles(String.valueOf(user.getUserGroup().getUsGId()));
	    		}else if(user.getDepartment()!=null){	    			
	    			Departmentvalue= (Integer)servletContext.getAttribute("Department-"+user.getDepartment().getNumber1()+"HasUserLogin");
	    			departmentRoles = roleService.getDepartmentRoles(user.getDepartment().getNumber1());
	    		}
	    		if((null==Departmentvalue||null==UserGroupvalue||Departmentvalue==1||UserGroupvalue==1)){
					 //自动授权管理之授权部门或用户组没人的角色开启
	    			if(null==Departmentvalue||Departmentvalue==1){
	    				if(departmentRoles!=null)
	    				for(Role role:departmentRoles){
	    					roleIds.add(String.valueOf(role.getRoleId()));
					    	if(role.getPermission()!=null){		    	
					    		AutoUserPermission.add(role);
					    		roleIds.add(role.getRoleId());
					    	}
	    				}
	    			}
	    			if(null==UserGroupvalue||UserGroupvalue==1){
	    				if(userGroupRoles!=null)
		    				for(Role role:userGroupRoles){
		    					roleIds.add(String.valueOf(role.getRoleId()));
						    	if(role.getPermission()!=null){		    	
						    		AutoUserPermission.add(role);
						    		roleIds.add(role.getRoleId());
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
		
		if (user.getRoles().size() > 0) {
			for (Role role : user.getRoles()) 
			{	
				if("false".equals(role.getHasUserLogin())){
					 //自动授权管理之授权请求角色开启
					requestRole = role.getRequestRole();
			    	if(requestRole!=null){		    	
			    		Role newRole=roleService.getRole(requestRole);
			    		if(newRole!=null){
				    		AutoUserPermission.add(newRole);
				    		roleIds.add(newRole.getRoleId());
			    		}
			    	}
				}
				roleIds.add(role.getRoleId());
				if(role.getPermission()==null) {
					
				}else{
					try {
						boolean exists=false;
						String hostAddress = InetAddress.getLocalHost().getHostAddress();
						  Session session = SecurityUtils.getSubject().getSession();
						String host = session.getHost();
								String[] split = host.split(":");
						List<Adress> adressByroles = adressService.getAdressByroles(userName);
						if(adressByroles.size()>0){	
							//地址管理判断
						for(Adress Othernewadress:adressByroles)
							{
								String ipEnd = Othernewadress.getIPEnd();
								String ipStart = Othernewadress.getIPStart();
								String ipSection=ipStart+"-"+ipEnd;
								if(split.length<=4){								
									exists=IPUtil.ipExistsInRange(host,ipSection);
								}
								 if(exists){
										Set<String> handleMappings=new HashSet<String>();
										for(Permission permission:role.getPermission())
										{
											handleMappings.add(permission.getName());	
												if(AutoUserPermission!=null){
													for(int o=0;o<AutoUserPermission.size();o++){
														for(Permission newpermission:AutoUserPermission.get(o).getPermission())
														{
															handleMappings.add(newpermission.getName());
														}
													}
												}
											info.addStringPermissions(handleMappings);
								 }
									}
							}
						}else{
							Set<String> handleMappings=new HashSet<String>();
							for(Permission permission:role.getPermission())
							handleMappings.add(permission.getName());	
							if(AutoUserPermission!=null){
								for(int o=0;o<AutoUserPermission.size();o++){
									for(Permission newpermission:AutoUserPermission.get(o).getPermission())
									handleMappings.add(newpermission.getName());
								}
							}
							info.setStringPermissions(handleMappings);
						}
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			info.addRoles(roleIds);
		}
		//临时授权
		ProvisionalAuthorization provisionalAuthorization = provisionalAuthorizationService.getRole(userName);
		if(provisionalAuthorization!=null){
			String recoveryTime = provisionalAuthorization.getRecoveryTime();
			String timeStr1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   
			if(recoveryTime.compareTo(timeStr1)>0)
			{
			String roleid = provisionalAuthorization.getRoleid();
			Role role = roleService.getRoleId(roleid);
			if(role!=null){		
				for(Permission Permission:role.getPermission())
				{
					String name = Permission.getName();
					info.addStringPermission(name);
				}
			}
			info.addRole(roleid);
			}
		}
		
		//用户排他属性和用户组排他属性
		Set<String> roles = info.getRoles();
		Set<String> PropertiesRoleIds=new HashSet<String>();
		ArrayList UserExclusiveRoleList = (ArrayList)servletContext.getAttribute("UserExclusive");
		if(UserExclusiveRoleList!=null){
			for(int i=0;i<UserExclusiveRoleList.size();i++){
				String object = (String)UserExclusiveRoleList.get(i);
				for(String role:roles)
				{
					if(!role.toString().equals(object.toString()))
					{
						PropertiesRoleIds.add(role);
					}else{
						String UsingUsername =(String)servletContext.getAttribute("User_Rejection_attribute"+role);
						if(UsingUsername!=null){
							if((UsingUsername.toString()).equals(userCode))
							{
								PropertiesRoleIds.add(role);
							}else{
								MDC.put("User_Rejection_attribute","当前使用用户排他属性用户名:"+UsingUsername);
								log.info("当前有人使用排他属性，您访问权限被阻止了，用户为："+UsingUsername.toString());
							}
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
				String object = (String)UserGroupExclusiveRoleList.get(i);
				for(String role:UserGroupExclusiveRole)
				{
					if(!role.toString().equals(object.toString()))
					{
						UserGroupPropertiesRoleIds.add(role);
					}else{
						String UsingUsername =(String)servletContext.getAttribute("UserGroupExclusiveProperties"+role);
						if(UsingUsername!=null){
							if((UsingUsername.toString()).equals(userCode))
							{
								UserGroupPropertiesRoleIds.add(role);
							}else{
								MDC.put("UserGroupExclusiveProperties","当前使用用户排他属性用户名:"+UsingUsername);
								log.info("当前有人使用排他属性，您访问权限被阻止了，用户为："+UsingUsername.toString());
							}
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
		Department Department=user.getDepartment();
		UserGroup userGroup=user.getUserGroup();
			if(Department.getRoles()!=null&&userGroup.getRoles()!=null){
			Set<Role> thisUserDepartmentRoles= Department.getRoles();
			Set<Role> thisUserUserGroupRoles=userGroup.getRoles();
			Set<String> Rejection_attributeRoleIds=new HashSet<String>();
				for(Role role:thisUserDepartmentRoles)
					for(Role OtherRole:thisUserUserGroupRoles)
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
				info.setRoles(Rejection_attributeRoleIds);
			}
		}
		//强制属性
		
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
		ServletRequest request = ((WebSubject)SecurityUtils.getSubject()).getServletRequest();   
    	ServletContext servletContext = request.getServletContext();
    	servletContext.setAttribute("thisUser", userCode);
		boolean BothEqualdepartment=false;
		boolean BothEqualUserGroup=false;
		Set<String> roleIds=new HashSet<String>();
		if(user.getUserGroup()!=null)
		{
			servletContext.setAttribute("UserGroup-"+user.getUserGroup().getUsGId()+"HasUserLogin", 0);  			
		}if(user.getDepartment()!=null)
		{
			servletContext.setAttribute("UserGroup-"+user.getDepartment().getNumber1()+"HasUserLogin", 0); 				
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
		    			BothEqualUserGroup=true;
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
		    	else if(Onlineuser.getDepartment()!=null){	
		    		Integer DepartmentCount = (Integer)servletContext.getAttribute("Department-"+Onlineuser.getDepartment().getNumber1()+"HasUserLogin");//有部门用户登录:人数	    			
		    		if(DepartmentCount==null||DepartmentCount==0||DepartmentCount==1)
		    		{
		    			DepartmentCount=0;
		    		}else{
		    		DepartmentCount=+1;//在线部门人数+1
		    		}
		    		if(user.getDepartment()!=null&&String.valueOf(user.getDepartment().getNumber1()).equals(String.valueOf(Onlineuser.getDepartment().getNumber1())))
	    			 {
		    			DepartmentCount=+1;
		    			Set<Role> roles = Onlineuser.getDepartment().getRoles();
 	    			if(roles!=null){
 	    				for(Role role:roles)
 			    		{	
 	    					roleIds.add(role.getRoleId());
 			    		}
 			    		}
	    					BothEqualdepartment=true;
	    			 }else if(user.getDepartment()!=null)
	    			 {
	    					Integer DepartmentCount1 = (Integer)servletContext.getAttribute("Department-"+user.getDepartment().getNumber1()+"HasUserLogin");//有部门用户登录:人数	    			
	    		    		if(DepartmentCount1==null||DepartmentCount1==0||DepartmentCount1==1)
	    		    		{
	    		    			DepartmentCount1=0;
	    		    		}else{
	    		    			DepartmentCount1=+1;//在线部门人数+1
	    		    		}
	    			 }
		    		servletContext.setAttribute("Department-"+Onlineuser.getDepartment().getNumber1()+"HasUserLogin", DepartmentCount);//有部门用户登录:人数	    			
		    	} 
		    }
	    	}
	    }
	    //基础角色更新
	    for(String roleId:roleIds)
	    {
	    	Role role = roleService.getRoleId(roleId);
	    	role.setHasUserLogin("true");
			roleService.updateRole(role);
	    }	
	    	
	    String salt="hdquan";
	    String loginCaptcha = captchaToken.getCaptchaCode();
	 
	    if (loginCaptcha == null || "".equals(loginCaptcha)) {
	        throw new AuthenticationException();
	    }

	    String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute("KAPTCHA_SESSION_KEY");
	
	    if (!loginCaptcha.equals(sessionCaptcha)) {
	        throw new AuthenticationException();
	    }
	   
	    
	    SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, user.getUsername(), ByteSource.Util.bytes(salt), this.getName());
		return simpleAuthenticationInfo;
	}
		public void clearCache()
		{
			PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
			super.clearCache(principals);
		}
}
