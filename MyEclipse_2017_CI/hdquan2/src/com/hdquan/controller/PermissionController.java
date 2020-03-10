package com.hdquan.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.MD5.Json;
import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Menu;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.TreeNode;
import com.hdquan.pojo.User;
import com.hdquan.service.PermissionService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserService;

@Controller
public class PermissionController extends NoPermissionException{

	@Autowired
	private PermissionService PermissionService;
	
	@Autowired
	private UserService UserService;
	
	private Logger log = Logger.getLogger(PermissionController.class);

	
	@RequestMapping("permission.action")
	public void datagrid(HttpServletRequest request,HttpServletResponse response,String id,String roleId
			,boolean currentUser,String deparementName) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		 Permission newpermission=new Permission();
		 BeanUtils.populate(newpermission,request.getParameterMap());
		 List<Permission> permission =null;
		 if(currentUser)
		 {
		    	ServletContext servletContext = request.getServletContext();
		    	String attribute =(String) servletContext.getAttribute("thisUser");
			 permission= UserService.findUserPermissionByName(attribute);
		 }else{
			 if(null!=deparementName&&!"null".equals(deparementName))
			 {
				 permission= PermissionService.getPermissionByDepartment(Integer.valueOf(deparementName));
			 }else{				 
				 permission= PermissionService.getPermission(id,roleId,newpermission);
			 }
		 }
		 List<TreeNode> tree=new ArrayList<TreeNode>();
		 for(Permission Otherpermission:permission)
			{	
				TreeNode n=new TreeNode();
				n.setId(String.valueOf(Otherpermission.getId()));
				n.setText(Otherpermission.getName());
				Map attributes=new HashMap();
				attributes.put("type", Otherpermission.getType());
				attributes.put("parentid", Otherpermission.getParentid());
				attributes.put("Rejection_attribute", Otherpermission.getRejection_attribute());
				attributes.put("Mandatory_attribute", Otherpermission.getMandatory_attribute());
				attributes.put("rank", Otherpermission.getRank());
				n.setAttributes(attributes);
				if(PermissionService.countChildren(n.getId())>0)
				{
					n.setState("closed");
				}
				tree.add(n);
			}
		WriteJson.writeJson(tree,response);
	}
	
	@RequestMapping("permissionByDepartment.action")
	public void permissionByDepartmentdatagrid(HttpServletRequest request,HttpServletResponse response,int number1) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		 List<Permission> permission = PermissionService.getPermissionByDepartment(number1);
		WriteJson.writeJson(permission,response);
	}
	@RequestMapping("getAllpermission.action")
	public void combobox(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		 response.setHeader("Content-Type" , "text/html");
		 List<Permission> permission = PermissionService.getPermission();
		WriteJson.writeJson(permission,response);
	}
}
