package com.hdquan.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import com.hdquan.pojo.ExtendDepartment;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.TreeNode;
import com.hdquan.pojo.User;
import com.hdquan.pojo.UserGroup;
import com.hdquan.service.DepartmentService;
import com.hdquan.service.PermissionService;
import com.hdquan.service.RoleService;

@Controller
public class DepartmentController extends NoPermissionException{
	
	@Autowired
	private DepartmentService departService;

	@Autowired
	private RoleService RoleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleService roleService;
	
	private Logger log = Logger.getLogger(DepartmentController.class);

	
	@RequestMapping("deleteDepartment.action")
	public void deleteDepartment(HttpServletRequest request,HttpServletResponse response,String ids) throws UnsupportedEncodingException
	{
		Json json=new Json();
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		try {
			departService.deleteDepartment(ids);
			json.setSuccess(true);
			json.setMsg("删除部门【"+ids+"】成功");
			MDC.put("hdquan","删除部门！");
			 log.info("删除部门【"+ids+"】成功");	
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除部门失败");
			MDC.put("hdquan","删除部门！");
			 log.info("删除部门【"+ids+"】失败");	
		}
		 WriteJson.writeJson(json,response);
	}
	
		
	
	@RequestMapping("insertDepartment.action")
	public void insert(HttpServletRequest request,HttpServletResponse response,String[] permission) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		Map<String, String[]> parameterMap = request.getParameterMap();
		String parentDepartment = request.getParameter("parentDepartment");
		Json json=new Json();
		String name=null;
		if(parentDepartment.equals("") || parentDepartment==null)
		{
			try {
				Department department=new Department();
				BeanUtils.populate(department, parameterMap);	
				name=department.getName();
				Department insertDepartment = departService.insert(department);
				   if(permission!=null){
						for(String id:permission)
						{	
							Role roles2 = roleService.getRole(id);
							if(roles2!=null)
							{
								Role role=new Role();
								role.setHasUserLogin(roles2.getHasUserLogin());
								role.setRequestRole(roles2.getRequestRole());
								role.setRoleId(roles2.getRoleId());						
								role.setDepartment(insertDepartment);
								role.setPermission(roles2.getPermission());
									for(Permission p:roles2.getPermission())
									{		
										Permission permission2 = permissionService.getPermission(String.valueOf(p.getId()));
										Set<Role> roles3 = permission2.getRoles();
										roles3.add(role);
										permissionService.insertPermission(permission2);
									}
								}
						}
						
				  }
				json.setMsg("创建根部门成功！");
				json.setSuccess(true);
				MDC.put("hdquan","创建根部门！");
				 log.info("创建根部门【"+department.getName()+"】成功");	
			} catch (Exception e) {
				json.setMsg("创建根部门失败！");
				json.setSuccess(false);
				MDC.put("hdquan","创建根部门！");
				 log.info("创建根部门【"+name+"】失败");	
			}
			WriteJson.writeJson(json,response);
		}else
		{	
			try {
				Integer IntparentDepartment = Integer.valueOf(parentDepartment);
				//获取到上级部门信息
				 Set<Role> roles = departService.update(IntparentDepartment);
					ExtendDepartment extendDepartment=new ExtendDepartment();
					BeanUtils.populate(extendDepartment, parameterMap);	
					name=extendDepartment.getName();
					ExtendDepartment insertDepartment = departService.insert(extendDepartment);
					   if(permission!=null){
							for(String id:permission)
							{	
									Role roles2 = roleService.getRole(id);
									if(roles2!=null)
									{
										boolean NothisRoleID=true;
										for(Role role:roles)
										{
											if(String.valueOf(role.getRoleId()).equals(String.valueOf(roles2.getRoleId())))
											{
												NothisRoleID=false;
												break;
											}
										}
										if(NothisRoleID)
										{											
											roles.add(roles2);
										}
									}
							}
					  }
				for(Role role:roles){
					Role newrole=new Role();
					newrole.setHasUserLogin(role.getHasUserLogin());
					newrole.setRequestRole(role.getRequestRole());
					newrole.setRoleId(role.getRoleId());						
					newrole.setDepartment(insertDepartment);//下级子部门自动继承上一级部门的角色
					newrole.setPermission(role.getPermission());
					for(Permission p:role.getPermission())
					{		
						Permission permission2 = permissionService.getPermission(String.valueOf(p.getId()));
						Set<Role> roles3 = permission2.getRoles();
						roles3.add(newrole);
						permissionService.insertPermission(permission2);
					}
				}
				
				json.setMsg("创建子部门成功！");
				json.setSuccess(true);
				MDC.put("hdquan","创建子部门！");
				 log.info("创建子部门【"+extendDepartment.getName()+"】成功");
			} catch (NumberFormatException e) {
				json.setMsg("创建子部门失败！");
				json.setSuccess(false);
				MDC.put("hdquan","创建子部门！");
				 log.info("创建子部门【"+name+"】失败");	
			}
			WriteJson.writeJson(json,response);
		}
	}
	
	@RequestMapping("updateDepartment.action")
	public void updateDepartment(HttpServletRequest request,HttpServletResponse response,int[] role) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
		request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		Json json=new Json();
		String name=null;
	try {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String parentDepartment = request.getParameter("parentDepartment");
		String number1 = request.getParameter("number1");
		String parentDepartment1 = request.getParameter("parentDepartment1");
			if(number1!=null&&!"".equals(number1))
			{
				List<Role> departmentRoles = roleService.getDepartmentRoles(Integer.parseInt(number1));
				for(Role Role:departmentRoles)
				{
					roleService.deleteRole(String.valueOf(Role.getNumber()));//删除原先的角色
				}
				Department Department = departService.getDepartment(Integer.parseInt(number1));		
				if(role!=null){
				for(int roleId:role)
				{	
					Role roleId2 = roleService.getRoleId(String.valueOf(roleId));
					Role newrole=new Role();
					newrole.setHasUserLogin(roleId2.getHasUserLogin());
					newrole.setRequestRole(roleId2.getRequestRole());
					newrole.setRoleId(roleId2.getRoleId());						
					newrole.setDepartment(Department);
					newrole.setPermission(roleId2.getPermission());
					newrole.setDepartment(Department);
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
					MDC.put("hdquan","修改部门权限！");
					 log.info("修改部门【"+Department.getName()+"】权限【"+permissionname+"】成功");
				}
				}
			}
	//修改部门除角色外的内容
		Department updateDepartment = departService.getDepartment(Integer.parseInt(parentDepartment1));		
		if(parentDepartment!=null&&!"".equals(parentDepartment)){
			ExtendDepartment extendDepartment=new ExtendDepartment();
			BeanUtils.populate(extendDepartment, parameterMap);
			if(updateDepartment!=null)
			{
				extendDepartment.setParentDepartment(updateDepartment.getNumber1());
			}
			try {
				departService.updateDepartment(null,extendDepartment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Department department=new Department();
			BeanUtils.populate(department, parameterMap);
			departService.updateDepartment(department,null);
			}
		json.setSuccess(true);
		json.setMsg("修改部门信息成功");
		MDC.put("hdquan","修改部门！");
		 log.info("修改部门【"+name+"】成功");
	} catch (Exception e) {
		json.setSuccess(false);
		json.setMsg("修改部门信息失败");
		MDC.put("hdquan","修改部门！");
		 log.info("修改部门【"+name+"】失败");	
	}
	WriteJson.writeJson(json, response);
	}
	
	@RequestMapping("getDepartment.action")
	public void getDepartment(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    String name = request.getParameter("q");
		    Object department;
		    if(name==null||name.equals("")){		    	
		    	 department = departService.getDepartments();
		    }
		    else{
		    	department= departService.getDepartment(name);
		    }
		WriteJson.writeJson(department,response);
	}

	@RequestMapping("getAllDepartment.action")
	public void getAllDepartment(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		   List<Object> departments = departService.getDepartments();
		   List<TreeNode> tree=new ArrayList<TreeNode>();
		   for(Object department:departments)
			{	
				  TreeNode n=new TreeNode();
			  if(department instanceof ExtendDepartment)
			  {
				  ExtendDepartment newdepartment=(ExtendDepartment)department;
				 n.setId(String.valueOf(newdepartment.getNumber1()));
				 n.setText(newdepartment.getName());
				 n.setRoles(newdepartment.getRoles());
				 n.setUsers(newdepartment.getUsers());
				 n.set_parentId(String.valueOf(newdepartment.getParentDepartment()));
					Map attributes=new HashMap();
					attributes.put("headerName",newdepartment.getHeaderName());
					attributes.put("officeLocation", newdepartment.getOfficeLocation());
					attributes.put("telephone",newdepartment.getTelephone());
					attributes.put("lastDepartment",newdepartment.isLastDepartment());
					n.setAttributes(attributes);
					tree.add(n);
			  }else if(department instanceof Department){
				  Department newdepartment=(Department)department;
					 n.setId(String.valueOf(newdepartment.getNumber1()));
					 n.setText(newdepartment.getName());
					 n.setRoles(newdepartment.getRoles());
					 n.setUsers(newdepartment.getUsers());
						Map attributes=new HashMap();
						attributes.put("headerName",newdepartment.getHeaderName());
						attributes.put("officeLocation", newdepartment.getHeaderName());
						attributes.put("telephone",newdepartment.getTelephone());
						attributes.put("lastDepartment",newdepartment.isLastDepartment());
						n.setAttributes(attributes);
						tree.add(n);
			  }else{
				  break;
			  }
				}
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("total",departService.getTotal());
			m.put("rows",tree);
			MDC.put("hdquan","查看部门！");
			 log.info("查看当前所有部门");
			 WriteJson.writeJson(m,response);
	}
	
	@RequestMapping("getUserByDepartment.action")
	public void getUser(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		  response.setHeader("Content-Type" , "text/html");
		   List<Object> departments = departService.getDepartments();
		  Map<String,Object> m=new HashMap<String,Object>();
		  List<TreeNode> tree=new ArrayList<TreeNode>();
		  int length = 0;
		  List<User> users=new ArrayList<User>();
		   for(Object department:departments)
		  {
				  if(department instanceof ExtendDepartment)
				  {
					  ExtendDepartment newdepartment=(ExtendDepartment)department;
					  length+=newdepartment.getUsers().size();
					  for(User user:newdepartment.getUsers())
					  {					  
						  users.add(user);
					  }
				  }else if(department instanceof Department)
				  {
					  Department newdepartment=(Department)department;
					  length+=newdepartment.getUsers().size();
					  for(User user:newdepartment.getUsers())
					  {					  
						  users.add(user);
					  }
				  }
		  }
		  m.put("rows",users);  
		  m.put("total",length);
			MDC.put("hdquan","获取用户信息！");
			 log.info("获取用户信息成功");
			 WriteJson.writeJson(m,response);
	}
}
