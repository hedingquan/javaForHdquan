package com.hdquan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdquan.mapper.ElementMapper;
import com.hdquan.pojo.Element;
import com.hdquan.service.ElementService;

@Service
public class ElementServiceimpl implements ElementService{
		@Resource
		private ElementMapper elementMapper;

	public List<Element> selByRid(int rid) {
		// TODO Auto-generated method stub
		return elementMapper.selByRid(rid);
	}
	
}
