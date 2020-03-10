package com.hdquan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdquan.mapper.MenuMapper;
import com.hdquan.pojo.Menu;
import com.hdquan.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuMapper menuMapper;
	public List<Menu> show() {
		return menuMapper.selByPid(0);
	}
	
}
