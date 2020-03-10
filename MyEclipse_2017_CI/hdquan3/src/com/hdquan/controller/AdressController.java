package com.hdquan.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.MD5.Json;
import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Adress;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.AdressService;
import com.hdquan.service.RoleService;

@Controller
public class AdressController extends NoPermissionException{

	@Autowired
	private AdressService adressService;
	
	@Autowired
	private RoleService roleService;

	private Logger log = Logger.getLogger(AdressController.class);
	
	@RequestMapping("getadress.action")
	@RequiresPermissions("query:adress")
	public void getAdress(HttpServletRequest request,HttpServletResponse response,boolean  allAdress) throws UnsupportedEncodingException
	{
	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		  response.setHeader("Content-Type" , "text/html");
		
			   String principal = (String)SecurityUtils.getSubject().getPrincipal();
			    User k=new User();
			      if(!allAdress)
			      {
			    	    k.setUsercode(principal);
			      }
		  Adress newadress=new Adress();
		    String iPStart = request.getParameter("IPStart");
		    String iPEnd = request.getParameter("IPEnd");
		    if(iPStart!=null||iPEnd!=null)
		    {
		    	newadress.setIPEnd(iPEnd);
		    	newadress.setIPStart(iPStart);
		    }
		  List<Adress> adress = adressService.getAdress(newadress,k);
		  Map<String,Object> m=new HashMap<String,Object>();
			m.put("total",adressService.getTotal());
			m.put("rows",adress);
			MDC.put("hdquan","获取地址信息！");
			 log.info("获取地址信息成功");
			 WriteJson.writeJson(m,response);
	}
	
	@RequestMapping("deleteAdress.action")
	@RequiresPermissions("delete:adress")
	public void deleteAdress(HttpServletRequest request,HttpServletResponse response,String ids)
	{
		 response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type" , "text/html");
		Json j=new Json();
		 try {
			 adressService.deleteAdress(ids);
			 j.setSuccess(true);
			 j.setMsg("删除地址【"+ids+"】成功！");
				MDC.put("hdquan","删除地址！");
				 log.info("删除地址成功！"+ids);
		} catch (Exception e) {
			 j.setMsg("删除地址【"+ids+"】失败");
				MDC.put("hdquan","删除地址！");
				 log.info("删除地址失败！"+ids);
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("insertAdress.action")
	@RequiresPermissions("add:adress")
	public void insertAdress(HttpServletRequest request,HttpServletResponse response,String RoleId) throws IllegalAccessException, InvocationTargetException
	{
		 response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type" , "text/html");
		Json j=new Json();
		Adress adress=new Adress();
		Map<String, String[]> parameterMap = request.getParameterMap();
		BeanUtils.populate(adress, parameterMap);
		Set<Role> roles=new HashSet<Role>();
		for(Role role:roleService.getRoleId(RoleId))
		{
			roles.add(role);
		}
		adress.setRoles(roles);
	 try {
		 adressService.insertAdress(adress);
			 j.setSuccess(true);
			 j.setMsg("添加地址成功！");
				MDC.put("hdquan","添加地址！");
				 log.info("添加地址！地址区域为："+adress.getIPStart()+"-"+adress.getIPEnd());
		} catch (Exception e) {
			 j.setMsg("添加地址失败");
				MDC.put("hdquan","添加地址！");
				 log.info("添加地址失败！地址区域为："+adress.getIPStart()+"-"+adress.getIPEnd());
		}
		 WriteJson.writeJson(j,response);
	}
	
	@RequestMapping("updateAdress.action")
	@RequiresPermissions("update:address")
	public void updateAdress(HttpServletRequest request,HttpServletResponse response,int[] permission,String RoleId) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException
	{
	request.setCharacterEncoding( "utf-8" );
	 response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type" , "text/html");
	Json j=new Json();
	Adress adress=new Adress();
	Map<String, String[]> parameterMap = request.getParameterMap();
	BeanUtils.populate(adress, parameterMap);
	String parameter = request.getParameter("Id");
	adress.setId(Integer.parseInt(parameter));
	Set<Role> roles=new HashSet<Role>();
	for(Role role:roleService.getRoleId(RoleId))
	{
		roles.add(role);
	}
	adress.setRoles(roles);
	 try {
		 adressService.updateAdress(adress);
		 j.setSuccess(true);
		 j.setMsg("修改临时角色权限成功！");
			MDC.put("hdquan","更新地址！");
			 log.info("更新地址成功！地址区域为："+adress.getIPStart()+"-"+adress.getIPEnd());
	} catch (Exception e) {
		 j.setMsg("修改临时角色权限失败");
			MDC.put("hdquan","更新地址！");
			 log.info("更新地址失败!地址区域为："+adress.getIPStart()+"-"+adress.getIPEnd());
	}
	 WriteJson.writeJson(j,response);
	}
}
