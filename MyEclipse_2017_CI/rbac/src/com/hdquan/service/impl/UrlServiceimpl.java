package com.hdquan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdquan.mapper.UrlMapper;
import com.hdquan.pojo.Url;
import com.hdquan.service.UrlService;

@Service
public class UrlServiceimpl implements UrlService{
	@Resource
	private UrlMapper urlMapper;
	@Override
	public List<Url> selByRid(int rid) {
		// TODO Auto-generated method stub
		return urlMapper.selByRid(rid);
	}
	@Override
	public List<Url> showAll() {
		// TODO Auto-generated method stub
		return urlMapper.selAll();
	}
	
}
