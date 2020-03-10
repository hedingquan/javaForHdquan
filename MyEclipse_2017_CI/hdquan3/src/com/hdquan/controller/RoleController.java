package com.hdquan.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.MD5.Json;
import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.PermissionService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserService;

@Controller
public class RoleController extends NoPermissionException{

	@Autowired
	private RoleService RoleService;
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	
	private Logger log = Logger.getLogger(RoleController.class);

	
	@RequestMapping("insertRole.action")
	@RequiresPermissions("add:role")
	public void insertRole(HttpServletRequest request,HttpServletResponse response,int[] permission,String roleId) throws IllegalAccessException, InvocationTargetException
	{
		Json j=new Json();
	 try {
			request.setCharacterEncoding("utf-8");
			 response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type" , "text/html");
	    String principal = (String)SecurityUtils.getSubject().getPrincipal();
		User user = userService.queryByNameAndPwd(principal);
		for(int i=0;i<permission.length;i++)
		{	
			Role roles2=null;
			try {
				roles2 = RoleService.getRole(permission[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(roles2!=null)
			{
				Role role=new Role();
				role.setHasUserLogin(roles2.getHasUserLogin());
				role.setRequestRole(roles2.getRequestRole());
				if(roleId!=null)
				{					
					role.setRoleId(roleId);		
				}
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
			 j.setSuccess(true);
			 j.setMsg("添加角色成功！");
				MDC.put("hdquan","添加角色！");
				 log.info("添加角色成功！权限为："+permission);
		} catch (Exception e) {
			 j.setMsg("添加角色失败");
				MDC.put("hdquan","添加角色！");
				 log.info("添加角色失败！权限为："+permission);
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("deleteRole.action")
	@RequiresPermissions("delete:role")
	public void deleteRole(HttpServletRequest request,HttpServletResponse response,String ids)
	{		
		Json j=new Json();
		try {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type" , "text/html");
		
		for(String roleId:ids.split(","))
		{
			if(0<Integer.parseInt(roleId)&&Integer.parseInt(roleId)<33)
			{
				j.setSuccess(false);
				 j.setMsg("删除角色失败！");
				MDC.put("hdquan","删除角色！");
				 log.info("1-32号角色不能删除------"+"你有选择角色ID"+Integer.parseInt(roleId)+"----请选择其他角色");
			}else{
				 RoleService.deleteRole(roleId);
				 j.setSuccess(true);
				 j.setMsg("删除角色【"+ids+"】成功！");
					MDC.put("hdquan","删除角色！");
					 log.info("删除角色成功！"+ids);
			}
		}
		} catch (Exception e) {
			 j.setMsg("删除角色【"+ids+"】失败");
				MDC.put("hdquan","删除角色！");
				 log.info("删除角色失败！"+ids);
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("updateRole.action")
	@RequiresPermissions("update:role")
	public void updateRole(HttpServletRequest request,HttpServletResponse response,int[] permission,String roleId) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
	request.setCharacterEncoding( "utf-8" );
	 response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type" , "text/html");
	Json j=new Json();
	Permission permission2 =null;
	 try {
		 boolean continueUpdate=true;
		 for(int i=0;i<permission.length;i++)
			{
				if(0<Integer.parseInt(roleId)&&Integer.parseInt(roleId)<33)
				{
					 j.setSuccess(false);
					 j.setMsg("修改角色权限失败！");
					MDC.put("hdquan","更新角色！");
					 log.info("1-32号角色不能修改------"+"你选择的权限id"+permission[i]+"----请选择其他角色");
					 continueUpdate=false;
					 break;
				}else{
					 for(Role role:RoleService.getRoles(roleId))
					 {
						 RoleService.deleteRole(String.valueOf(role.getNumber()));//删除原先的角色
					 }
				}
			}
		if(continueUpdate)
		{
			for(int i=0;i<permission.length;i++)
			{
					Role roles2=null;
					try {
						roles2 = RoleService.getRole(permission[i]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(roles2!=null)
					{
						Role role=new Role();
						role.setHasUserLogin(roles2.getHasUserLogin());
						role.setRequestRole(roles2.getRequestRole());
						if(roleId!=null)
						{					
							role.setRoleId(roleId);		
						}	
						role.setPermission(roles2.getPermission());
							for(Permission p:roles2.getPermission())
							{		
								permission2=permissionService.getPermission(String.valueOf(p.getId()));
								Set<Role> roles3 = permission2.getRoles();
								roles3.add(role);
								permissionService.insertPermission(permission2);
							}
					}
					 j.setSuccess(true);
					 j.setMsg("修改角色权限成功！");
					MDC.put("hdquan","更新角色！");
					 log.info("更新角色成功！权限为："+permission2.getName());
			}
		}
	 }catch (Exception e) {
		 j.setMsg("修改角色权限失败");
			MDC.put("hdquan","更新角色！");
			 log.info("更新角色失败！权限为："+permission2.getName());
	}
	 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("role.action")
	@RequiresPermissions("query:role")
	public void datagrid(HttpServletRequest request,HttpServletResponse response,int page,int rows,String sort,String order
			,boolean allRole
			) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
			Map<String,Object> m=new HashMap<String,Object>();
		    String principal = (String)SecurityUtils.getSubject().getPrincipal();
		    List<Role> l=null;
		    if(!allRole){
		    	 User k=new User();
		    	k.setUsercode(principal);
		    	l=RoleService.getRoles(page,rows,sort,order,k);
		    	m.put("total",RoleService.getThisUserTotal(principal));
		    }else{		    	
		    	l=RoleService.getRoles(page,rows,sort,order,new User());
		    	m.put("total",RoleService.getTotal());
		    }
		m.put("rows",l);
		m.put("page",page);
		MDC.put("hdquan","查询角色！");
		 log.info("查询角色成功！");
		WriteJson.writeJson(m,response);
	}
	
	@RequestMapping("comboboxRole.action")
	public void allRolecombobox(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		 List<Role> roles=RoleService.getRoles();
		WriteJson.writeJson(roles,response);
	}
	@RequestMapping("comboboxRoleByDepartment.action")
	public void RoleByDepartmentcombobox(HttpServletRequest request,HttpServletResponse response,int number1) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		 List<Role> roles=RoleService.getDepartmentRoles(number1);
		WriteJson.writeJson(roles,response);
	}
}
