package com.hdquan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.pojo.PageInfo;
import com.hdquan.service.PeopleServlet;

public class PeopleServletImpl implements PeopleServlet{
	public PageInfo showpage(int pageSize, int pageNumber) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		long count=session.selectOne("com.hdquan.mapper.PeopleMapper.selCount");//总条数
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		System.out.println(map);
		pi.setList(session.selectList("com.hdquan.mapper.PeopleMapper.selByPage",map));
	return pi;
	}
}
