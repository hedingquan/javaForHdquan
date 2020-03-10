package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Menu;

public interface MenuService {
	
	public List<Menu> tree(Menu menu);

	public Long countChildren(String id);
}
