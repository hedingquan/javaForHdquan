package com.hdquan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hdquan.mapper.FilesMapper;
import com.hdquan.pojo.Files;
import com.hdquan.pojo.Users;
import com.hdquan.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService{
	@Resource
	private FilesMapper filesMapper;

	public List<Files> show() {
	return filesMapper.selAll();
	}

	@Override
	public int updCount(int id,Users users,String name) {
		Logger logger=Logger.getLogger(FilesServiceImpl.class);
		logger.info(users.getUsername()+"œ¬‘ÿ¡À"+name);
		return filesMapper.updCountById(id);
	}
}
