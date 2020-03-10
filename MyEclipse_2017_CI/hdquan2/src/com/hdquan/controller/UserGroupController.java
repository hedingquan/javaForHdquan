package com.hdquan.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.MD5.Json;
import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.TreeNode;
import com.hdquan.pojo.User;
import com.hdquan.pojo.UserGroup;
import com.hdquan.service.DepartmentService;
import com.hdquan.service.PermissionService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserGroupService;

@Controller
public class UserGroupController extends NoPermissionException{

	@Autowired
	private UserGroupService userGroupService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService departmentService;
	
	private Logger log = Logger.getLogger(UserGroupController.class);
	
	@RequestMapping("getUserGroup.action")
	public void getUserGroup(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		  response.setHeader("Content-Type" , "text/html");
		  List<UserGroup> userGroup = userGroupService.getUserGroup();
		  String lookusers = request.getParameter("lookusers");
		  Map<String,Object> m=new HashMap<String,Object>();
		  List<TreeNode> tree=new ArrayList<TreeNode>();
		  int length = 0;
		  List<User> users=new ArrayList<User>();
		  for(UserGroup ug:userGroup)
		  {
			  TreeNode n=new TreeNode();
			  if(lookusers!=null&&"true".equals(lookusers))
			  {
				  length+=ug.getUsers().size();
				  for(User user:ug.getUsers())
				  {					  
					  users.add(user);
				  }
				  continue;
			  }else{
				  n.setId(String.valueOf(ug.getUsGId()));
				  n.setGroup(ug.getUsGName());
				  Map attributes=new HashMap();
				attributes.put("Users",ug.getUsers());
				attributes.put("descipt",ug.getDescipt());
				attributes.put("leaderName",ug.getLeaderName());
				attributes.put("time",ug.getTime());
				attributes.put("Roles",ug.getRoles());
				n.setAttributes(attributes);
				tree.add(n);
				length=userGroupService.getTotal().intValue();
				continue;
			  }
		  }
		  if(lookusers!=null&&"true".equals(lookusers))
		  {
		  m.put("rows",users);  
		  }else{			  
			  m.put("rows",tree);
		  }
		  m.put("total",length);
			MDC.put("hdquan","获取用户组信息！");
			 log.info("获取用户组信息成功");
			 WriteJson.writeJson(m,response);
	}
	
	@RequestMapping("insertUserGroup.action")
	public void insertUserGroup(HttpServletRequest request,HttpServletResponse response,String permission,String parentDepartment) throws UnsupportedEncodingException
	{
	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		  response.setHeader("Content-Type" , "text/html");
		  Json json=new Json();
		 try {
			 Map<String, String[]> parameterMap = request.getParameterMap();
			 UserGroup userGroup=new UserGroup();
			 BeanUtils.populate(userGroup, parameterMap);
			 String timeStr1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		         System.out.println("当前时间为:"+timeStr1);
		         userGroup.setTime(timeStr1);
		         Department department =(Department) departmentService.getDepartment(Integer.valueOf(parentDepartment));
		         userGroup.setDepartment(department);
		         UserGroup insertUserGroup = userGroupService.insertUserGroup(userGroup);
		         if(permission!=null){
							for(String id:permission.split(","))
							{
								Set<Role> roles = department.getRoles();
								 List<Role> roles2 = permissionService.getRoles(id);
									if(roles2!=null)
									{
										for(Role role:roles2){
											if(role.getDepartment()!=null&&role.getDepartment().getNumber1()==department.getNumber1())
											{
												Role role1=new Role();
												role1.setHasUserLogin(role.getHasUserLogin());
												role1.setRequestRole(role.getRequestRole());
												role1.setRoleId(role.getRoleId());						
												role1.setDepartment(department);
												role1.setUserGroup(insertUserGroup);
												role1.setPermission(role.getPermission());
													for(Permission p:role.getPermission())
													{		
														Permission permission2 = permissionService.getPermission(String.valueOf(p.getId()));
														Set<Role> roles3 = permission2.getRoles();
														roles3.add(role1);
														permissionService.insertPermission(permission2);
													}
												break;
											}
										}
									}
							}
		         }
			json.setMsg("创建用户组成功！");
			json.setSuccess(true);
			MDC.put("hdquan","添加用户组！");
			 log.info("添加用户组信息成功");
		} catch (Exception e) {
			json.setMsg("创建用户组失败！请重新申请");
			json.setSuccess(true);
			MDC.put("hdquan","添加用户组！");
			 log.info("添加用户组信息失败");
		}
		 WriteJson.writeJson(json,response);
	}
	
	@RequestMapping("deleteUserGroup.action")
	public void deleteUserGroup(HttpServletRequest request,HttpServletResponse response,String ids) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type" , "text/html");
		Json json=new Json();
		try {
			List<Role> userGroupRoles = roleService.getUserGroupRoles(ids);
			userGroupService.deleteUserGroup(ids);
			String a="";
			for(int i=0;i<userGroupRoles.size();i++)
			{
				a+=userGroupRoles.get(i).getNumber()+",";
			}
			 roleService.deleteRole(a);
			json.setSuccess(true);
			json.setMsg("删除用户组【"+ids+"】成功");
			MDC.put("hdquan","删除用户组！");
			 log.info("删除用户组信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("删除用户组失败");
			MDC.put("hdquan","删除用户组！");
			 log.info("删除用户组信息失败");
		}
		 WriteJson.writeJson(json,response);
	}
	
	@RequestMapping("updateUserGroup.action")
	public void updateUserGroup(HttpServletRequest request,HttpServletResponse response,String permission) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
	request.setCharacterEncoding( "utf-8" );
	 response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type" , "text/html");
	UserGroup userGroup = userGroupService.getUserGroup(request.getParameter("id"));
	Json j=new Json();
	try{
	 userGroup.setLeaderName(request.getParameter("leaderName"));
	 userGroup.setDescipt(request.getParameter("descipt"));
	UserGroup updateUserGroup = userGroupService.updateUserGroup(userGroup);
    if(permission!=null){
		for(String id:permission.split(","))
		{		
		 List<Role> roles2 = permissionService.getRoles(id);
				if(roles2!=null)
				{
					for(Role role:roles2){		
						role.setUserGroup(updateUserGroup);
						roleService.OtherinsertRole(role);
					}
				}
		}
    }
		 j.setSuccess(true);
		 j.setMsg("修改用户组成功！");
			MDC.put("hdquan","更新用户组！");
			 log.info("更新用户组成功！");
	} catch (Exception e) {
		 j.setMsg("修改用户组失败");
			MDC.put("hdquan","更新用户组！");
			 log.info("更新用户组失败!");
	}
	 WriteJson.writeJson(j,response);
	}
	@RequestMapping("getUserGroupByDepartment.action")
	public void getUserGroupByDepartment(HttpServletRequest request,HttpServletResponse response,String permission) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
	request.setCharacterEncoding( "utf-8" );
	 response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type" , "text/html");
	String parameter = request.getParameter("deparementName");
	Json j=new Json();
	List<UserGroup> userGroupByDepartment=null;
	try{
		userGroupByDepartment= userGroupService.getUserGroupByDepartment(Integer.parseInt(parameter));
		 j.setSuccess(true);
		 j.setMsg("修改用户组成功！");
			MDC.put("hdquan","更新用户组！");
			 log.info("更新用户组成功！");
	} catch (Exception e) {
		 j.setMsg("修改用户组失败");
			MDC.put("hdquan","更新用户组！");
			 log.info("更新用户组失败!");
	}
	 WriteJson.writeJson(userGroupByDepartment,response);
	}
	
	@RequestMapping("updateUserGroupRoles.action")
	public void updateUserGroupRoles(HttpServletRequest request,HttpServletResponse response,int[] role) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
	request.setCharacterEncoding( "utf-8" );
	 response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type" , "text/html");
	String usGId = request.getParameter("usGId");
	Json j=new Json();
	if(role==null)
	{
		List<Role> departmentRoles = userGroupService.getDepartmentRoles(Integer.parseInt(usGId));		
		WriteJson.writeJson(departmentRoles,response);
	}else{
		if(usGId!=null&&!"".equals(usGId))
		{
			 List<Role> userGroupRoles = roleService.getUserGroupRoles(usGId);
			for(Role Role:userGroupRoles)
			{
				roleService.deleteRole(String.valueOf(Role.getNumber()));//删除原先的角色
			}
			Department department = userGroupService.getDepartment(Integer.parseInt(usGId));		
			UserGroup userGroup = userGroupService.getUserGroup(usGId);
			if(role!=null){
			for(int roleId:role)
			{	
				Role roleId2 = roleService.getRoleId(String.valueOf(roleId),department.getNumber1());
				Role newrole=new Role();
				newrole.setHasUserLogin(roleId2.getHasUserLogin());
				newrole.setRequestRole(roleId2.getRequestRole());
				newrole.setRoleId(roleId2.getRoleId());						
				newrole.setDepartment(department);
				newrole.setUserGroup(userGroup);
				newrole.setPermission(roleId2.getPermission());
				//添加修改后的角色
				String permissionname="";
				for(Permission p:roleId2.getPermission())
				{		
					Permission permission2 = permissionService.getPermission(String.valueOf(p.getId()));
					Set<Role> roles3 = permission2.getRoles();
					roles3.add(newrole);
					permissionService.insertPermission(permission2);
					permissionname+=permission2.getName()+",";
				}
				MDC.put("hdquan","修改用户组权限！");
				 log.info("修改用户组【"+userGroup.getUsGName()+"】权限【"+permissionname+"】成功");
			}
			}
		}
	}
	}
}
