package com.hdquan.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.mapper.LogMapper;
import com.hdquan.pojo.Log;


public class Test {
	public static void main(String args[]) throws IOException
	{
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
//		LogMapper logMapper = session.getMapper(LogMapper.class);//鎺ュ彛瀹炰緥鍖�
//		List<Log> list = logMapper.selAll();
//		for(Log log:list)
//		{
//			System.out.println(log.toString());
//		}
		
		
		
		LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selByAccInAccOut("1", "3");
		for(Log log:list)
		{
			System.out.println(log.toString());
		}
		session.close();
	}
}
