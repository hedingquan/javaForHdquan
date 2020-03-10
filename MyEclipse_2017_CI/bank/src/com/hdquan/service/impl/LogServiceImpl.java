package com.hdquan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.pojo.Log;
import com.hdquan.pojo.PageInfo;
import com.hdquan.service.LogService;

public class LogServiceImpl implements LogService{

	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize",pageSize);
		List<Log> list=session.selectList("com.hdquan.mapper.LogMapper.selByPage",map);
		long count=session.selectOne("com.hdquan.mapper.LogMapper.selCount");
		PageInfo pi=new PageInfo();
		pi.setList(list);
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
