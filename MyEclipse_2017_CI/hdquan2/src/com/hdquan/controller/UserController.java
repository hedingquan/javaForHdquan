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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hdquan.MD5.Json;
import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.TreeNode;
import com.hdquan.pojo.User;
import com.hdquan.pojo.UserGroup;
import com.hdquan.service.DepartmentService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserGroupService;
import com.hdquan.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class UserController extends NoPermissionException{
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserGroupService userGroupService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private RoleService roleService;
	
	private Logger log = Logger.getLogger(UserController.class);
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping("user.action")
	public void datagrid(HttpServletRequest request,HttpServletResponse response,int page,int rows,String sort,String order
			) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		String parameter = request.getParameter("realName");
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		User w=new User();
		Map<String, String[]> parameterMap = request.getParameterMap();
		BeanUtils.populate(w, parameterMap);
		List<User> l=userService.getUsers(page,rows,sort,order,w);
		List<User> nl=new ArrayList<User>();
		for(User u:l)
		{
			User nu=new User();
			org.springframework.beans.BeanUtils.copyProperties(u, nu);
			nl.add(nu);
		}
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("total",userService.getTotal());
		m.put("rows",nl);
		m.put("page",page);
		WriteJson.writeJson(m,response);
		MDC.put("hdquan","查询用户！");
		 log.info("查询用户成功！");
	}
	
	
	@RequestMapping("findUserByUserId")
	public String findUserByUserId(HttpServletRequest req) throws Exception
	{
		userService.findUserByUserId(1);
		return "login";
	}

	@RequestMapping("findUserByusercode.action")
	public void findUserDepartmentByName(HttpServletRequest request,String usename,HttpServletResponse response) throws Exception
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		   response.setHeader("Content-Type" , "text/html");
		 User thisuser = userService.queryByNameAndPwd(usename);
		 Json j=new Json();
		 if(thisuser==null)
		 {
			 j.setSuccess(false);
			 j.setMsg("查询个人信息【"+thisuser.getUsercode()+"】失败！");
			MDC.put("hdquan","查询个人信息！");
			 log.info("查询个人信息【"+thisuser.getUsercode()+"】失败！");
		 }else{
			 j.setSuccess(true);
			 j.setMsg("查询个人信息【"+thisuser.getUsercode()+"】成功！");
			MDC.put("hdquan","查询个人信息！");
			 log.info("查询个人信息【"+thisuser.getUsercode()+"】成功！");
		 }
		 Map<String,Object> m=new HashMap<String,Object>();
		 UserGroup userGroup = thisuser.getUserGroup();
		 Set<Role> roles = thisuser.getRoles();
		 int size = roles.size();
		  List<TreeNode> tree=new ArrayList<TreeNode>();
	
			  TreeNode n=new TreeNode();
			  Map attributes=new HashMap();
			  if(userGroup!=null){				  
				  n.setId(String.valueOf(userGroup.getUsGId()));
				  n.setGroup(userGroup.getUsGName());
					attributes.put("descipt",userGroup.getDescipt());
					attributes.put("leaderName",userGroup.getLeaderName());
					attributes.put("time",userGroup.getTime());
			  }
			attributes.put("user",thisuser);
			if(roles!=null){				
				n.setRoles(roles);
			}
			n.setAttributes(attributes);
			tree.add(n);
			String parameter = request.getParameter("seacher_role");
			if("".equals(parameter)||null==parameter){				
				m.put("total",1);
			}else{
				m.put("total",size);
			}
			m.put("rows",tree);
		 WriteJson.writeJson(m,response);
	}
	
	@RequestMapping("insertUser.action")
	public void insertUser(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
			User user = (User) JSONObject.toBean(JSONObject.fromObject(request.getParameter("user")), User.class);
		 Json j=new Json();
		 try {
			userService.insertUser(user);
			 j.setSuccess(true);
			 j.setMsg("添加【"+user.getUsercode()+"】成功！");
				MDC.put("hdquan","添加用户！");
				 log.info("添加用户【"+user.getUsercode()+"】成功！");
		} catch (Exception e) {
			 j.setMsg("添加【"+user.getUsercode()+"】失败,数据库已存在此用户！");
				MDC.put("hdquan","添加用户！");
				 log.info("添加用户【"+user.getUsercode()+"】失败,数据库已存在此用户！");
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("deleteUser.action")
	public void deleteUser(HttpServletRequest request,HttpServletResponse response,String userids) throws Exception
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		  response.setHeader("Content-Type" , "text/html");
		  Json j=new Json();
		  userService.deleteUser(userids);
		  j.setSuccess(true); 
		  MDC.put("hdquan","删除用户！");
			 log.info("删除用户【"+userids+"】成功！");
		 WriteJson.writeJson(j,response);//{success:true}	
	}
	
	@RequestMapping("updateUser.action")
	public void updateUser(HttpServletRequest request,HttpServletResponse response,int[] role) throws Exception
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		//User user=new User();
		User user = (User) JSONObject.toBean(JSONObject.fromObject(request.getParameter("user")), User.class);
		String userid = request.getParameter("userid");
			if(userid!=null){
				int parseInt = Integer.parseInt(userid);
				user = userService.findUserByUserId(parseInt);
				String usGName = request.getParameter("usGName");
				String name1 = request.getParameter("name1");
				Set<Role> roles=new HashSet<Role>();
				if(role!=null){
					for(int roleId:role)
					{	
						Role roleId2 = roleService.getRoleId(String.valueOf(roleId));
						roles.add(roleId2);
					}
					user.setRoles(roles);
				}
				if(usGName!=null)
				{			
					UserGroup userGroup = userGroupService.getUserGroup(usGName);
					user.setUserGroup(userGroup);
					 MDC.put("hdquan","用户组员工发生变动！");
					 log.info("更新用户组员工【"+user.getUsercode()+"】至"+user.getUserGroup().getUsGName()+"成功！");
				}
				if(name1!=null)
				{
					Department department = departmentService.getDepartment(Integer.valueOf(name1));
					user.setDepartment(department);
					 MDC.put("hdquan","部门员工发生变动！");
					 log.info("更新部门员工【"+user.getUsercode()+"】至"+user.getDepartment().getName()+"成功！");
				}
			}
		 Json j=new Json();
		 try {
				userService.updateUser(user);
				 j.setSuccess(true);
				 j.setMsg("编辑【"+user.getUsercode()+"】成功！");
				  MDC.put("hdquan","更新用户！");
					 log.info("更新用户【"+user.getUsercode()+"】成功！");
			} catch (Exception e) {
				 j.setMsg("编辑【"+user.getUsercode()+"】失败");
				  MDC.put("hdquan","更新用户！");
					 log.info("更新用户【"+user.getUsercode()+"】失败！");
			}
			 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("findUserRoleByName")
	public String findUserRoleByName(HttpServletRequest req) throws Exception
	{
		String realName="Ȩ";
		userService.findUserRoleByName(realName);
		 return "login";
	}
	
	@RequestMapping("findUserPermissionByName")
	public String findUserPermissionByName(HttpServletRequest req) throws Exception
	{
		String realName="Ȩ";
		userService.findUserPermissionByName(realName);
		 return "login";
	}
 }
