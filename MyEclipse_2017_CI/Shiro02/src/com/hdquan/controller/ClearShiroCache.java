package com.hdquan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.shiro.realm.CustomRealm;





//�ֶ�����controller���shiro�Ļ���
@Controller
public class ClearShiroCache {
	
//	ע��realm
	@Autowired
	private CustomRealm customRealm;
	@RequestMapping("/clearShiroCache")
	public String clearShiroCache()
	{
//		�������,������������Ҫ��service����customRealm.clearCache()
		customRealm.clearCache();
		return "/success.jsp";
	}
}

