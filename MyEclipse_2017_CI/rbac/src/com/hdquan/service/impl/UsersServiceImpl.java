package com.hdquan.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdquan.mapper.UsersMapper;
import com.hdquan.pojo.Users;
import com.hdquan.service.ElementService;
import com.hdquan.service.MenuService;
import com.hdquan.service.UrlService;
import com.hdquan.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
		private UsersMapper usersMapper;
		@Resource
		private MenuService menuServiceImpl;
		@Resource
		private ElementService elementServiceImpl;
		@Resource
		private UrlService urlServiceimpl;
		@Override
//	(1)
//		public Users login(Users users) {
//		Users user = usersMapper.selByUsers(users);
//		if(user!=null)
//		{
//			user.setMenus(menuServiceImpl.showMenu(user.getRid()));
//			user.setElement(elementServiceImpl.selByRid(user.getRid()));
//			user.setUrl(urlServiceimpl.selByRid(user.getRid()));
//		}
//		//	(1)	return usersMapper.selByUsers(users);
//		return user;
//	}
		public Map<String,Object> login(Users users) {
				Map<String,Object> map=new HashMap<>();
			Users user = usersMapper.selByUsers(users);
			if(user!=null)
			{
				user.setMenus(menuServiceImpl.showMenu(user.getRid()));
				user.setElement(elementServiceImpl.selByRid(user.getRid()));
				user.setUrl(urlServiceimpl.selByRid(user.getRid()));
				map.put("allurl", urlServiceimpl.showAll());
			}
			map.put("user", user);
			//	(1)	return usersMapper.selByUsers(users);
			return map;
		}
}
