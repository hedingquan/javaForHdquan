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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.MD5.Json;
import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.ProvisionalAuthorization;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.PermissionService;
import com.hdquan.service.ProvisionalAuthorizationService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserService;

@Controller
public class ProvisionalAuthorizationController extends NoPermissionException{
	
	private Logger log = Logger.getLogger(ProvisionalAuthorizationController.class);

	@Autowired
	private ProvisionalAuthorizationService provisionalAuthorizationService;
	
	@RequestMapping("PA_role.action")
	public void datagrid(HttpServletRequest request,HttpServletResponse response,int page,int rows,String sort,String order
			,boolean allRole
			) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");

		    String usercode = request.getParameter("usercode");
		    String roleid = request.getParameter("roleid");
		    String recoveryTime = request.getParameter("RecoveryTime");
		    ProvisionalAuthorization provisionalAuthorization=new ProvisionalAuthorization();
		    if(usercode!=null||roleid!=null||recoveryTime!=null)
		    {
			    provisionalAuthorization.setRecoveryTime(recoveryTime);
			    provisionalAuthorization.setRoleid(roleid);
			    provisionalAuthorization.setUsercode(usercode);
		    }
		    String principal = (String)SecurityUtils.getSubject().getPrincipal();
		    User k=new User();
		    if("on".equals(allRole)){
		    	allRole=true;
		    }
		      if(!allRole)
		      {
		    	    k.setUsercode(principal);
		      }
List<ProvisionalAuthorization> roles = provisionalAuthorizationService.getRoles(page,rows,sort,order,k,provisionalAuthorization);
		List<ProvisionalAuthorization> nl=new ArrayList<ProvisionalAuthorization>();
		for(ProvisionalAuthorization u:roles)
		{
			ProvisionalAuthorization nu=new ProvisionalAuthorization();
			org.springframework.beans.BeanUtils.copyProperties(u, nu);
			nl.add(nu);
		}
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("total",provisionalAuthorizationService.getTotal());
		m.put("rows",nl);
		m.put("page",page);
		MDC.put("hdquan","查询临时角色！");
		 log.info("查询临时角色成功！");
		WriteJson.writeJson(m,response);
	}
	
	@RequestMapping("PA_deleteRole.action")
	public void deleteRole(HttpServletRequest request,HttpServletResponse response,String ids)
	{
		 response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type" , "text/html");
		Json j=new Json();
		 try {
			 provisionalAuthorizationService.deleteRole(ids);
			 j.setSuccess(true);
			 j.setMsg("删除临时角色【"+ids+"】成功！");
				MDC.put("hdquan","删除临时角色！");
				 log.info("删除临时角色成功！"+ids);
		} catch (Exception e) {
			 j.setMsg("删除临时角色【"+ids+"】失败");
				MDC.put("hdquan","删除临时角色！");
				 log.info("删除临时角色失败！"+ids);
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("PA_insertRole.action")
	public void insertRole(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
	{
		 response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type" , "text/html");
		Json j=new Json();
		ProvisionalAuthorization provisionalAuthorization=new ProvisionalAuthorization();
		Map<String, String[]> parameterMap = request.getParameterMap();
		BeanUtils.populate(provisionalAuthorization, parameterMap);
	 try {
		 provisionalAuthorizationService.insertRole(provisionalAuthorization);
			 j.setSuccess(true);
			 j.setMsg("添加临时角色成功！");
				MDC.put("hdquan","添加临时角色！");
				 log.info("添加临时角色成功！用户为："+provisionalAuthorization.getUsercode()+"角色为"+provisionalAuthorization.getRoleid());
		} catch (Exception e) {
			 j.setMsg("添加临时角色失败");
				MDC.put("hdquan","添加临时角色！");
				 log.info("添加临时角色失败！用户为："+provisionalAuthorization.getUsercode()+"角色为"+provisionalAuthorization.getRoleid());
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("PA_updateRole.action")
	public void updateRole(HttpServletRequest request,HttpServletResponse response,int[] permission) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
	request.setCharacterEncoding( "utf-8" );
	 response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type" , "text/html");
	Json j=new Json();
	ProvisionalAuthorization provisionalAuthorization=new ProvisionalAuthorization();
	Map<String, String[]> parameterMap = request.getParameterMap();
	BeanUtils.populate(provisionalAuthorization, parameterMap);
	 try {
		 provisionalAuthorizationService.updateRole(provisionalAuthorization);
		 j.setSuccess(true);
		 j.setMsg("修改临时角色权限成功！");
			MDC.put("hdquan","更新临时角色！");
			 log.info("更新临时角色成功！权限为："+provisionalAuthorization.getUsercode()+"角色为"+provisionalAuthorization.getRoleid());
	} catch (Exception e) {
		 j.setMsg("修改临时角色权限失败");
			MDC.put("hdquan","更新临时角色！");
			 log.info("更新临时角色失败！权限为："+provisionalAuthorization.getUsercode()+"角色为"+provisionalAuthorization.getRoleid());
	}
	 WriteJson.writeJson(j,response);
	}
}
