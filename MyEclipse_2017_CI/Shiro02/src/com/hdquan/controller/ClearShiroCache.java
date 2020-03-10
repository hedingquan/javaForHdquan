package com.hdquan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.shiro.realm.CustomRealm;





//手动调用controller清除shiro的缓存
@Controller
public class ClearShiroCache {
	
//	注入realm
	@Autowired
	private CustomRealm customRealm;
	@RequestMapping("/clearShiroCache")
	public String clearShiroCache()
	{
//		清除缓存,将来正常开发要在service调用customRealm.clearCache()
		customRealm.clearCache();
		return "/success.jsp";
	}
}

