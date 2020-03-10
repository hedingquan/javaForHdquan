package com.hdquan.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.hdquan.mapper.LogMapper;
import com.hdquan.pojo.Log;
import com.hdquan.service.LogService;
import com.hdquan.util.mybatisUtil;

public class LogServiceImpl implements LogService{
	public int ins(Log log) {
		SqlSession session = mybatisUtil.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.ins(log);
	}

}
