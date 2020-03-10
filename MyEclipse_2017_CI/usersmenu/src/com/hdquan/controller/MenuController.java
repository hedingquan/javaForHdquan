package com.hdquan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdquan.pojo.Menu;
import com.hdquan.pojo.Users;

@Controller
public class MenuController {
	@RequestMapping("getMenu")
	@ResponseBody
	public List<Menu> showMenu(HttpSession session)
	{
		return ((Users)session.getAttribute("user")).getMenus();
	}
}
