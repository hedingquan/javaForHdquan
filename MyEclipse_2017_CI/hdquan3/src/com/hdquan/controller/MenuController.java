package com.hdquan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.MD5.WriteJson;
import com.hdquan.pojo.Menu;
import com.hdquan.pojo.TreeNode;
import com.hdquan.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/menu.action")
	public void menu(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		Menu menu=new Menu();
		BeanUtils.populate(menu, request.getParameterMap());
		List<Menu> menus = menuService.tree(menu);
		List<TreeNode> tree=new ArrayList<TreeNode>();
		for(Menu menu1:menus)
		{	
			TreeNode n=new TreeNode();
			n.setId(menu1.getId());
			n.setText(menu1.getText());
			Map attributes=new HashMap();
			attributes.put("url", menu1.getUrl());
			n.setAttributes(attributes);
			if(menuService.countChildren(n.getId())>0)
			{
				n.setState("closed");
			}
			tree.add(n);
		}
		WriteJson.writeJson(tree,response);
	}
 }
