package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.MenuDao;
import com.hdquan.pojo.Menu;
import com.hdquan.service.MenuService;

@Service
@Transactional
public  class MenuServiceImpl implements MenuService{

	@Autowired
	MenuDao menuDao;

	@Override
	public List<Menu> tree(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.tree(menu);
	}

	@Override
	public Long countChildren(String id) {
		// TODO Auto-generated method stub
		return menuDao.countChildren(id);
	}
	
}
