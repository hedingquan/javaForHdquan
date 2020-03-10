package com.hdquan.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.pojo.Log;


public class Test {
	public static void main(String args[]) throws IOException
	{
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		List<Object> list=session.selectList("com.hdquan.mapper.LogMapper.selAll");
		List<Object> list1=session.selectList("com.hdquan.mapper.LogMapper.selAll1");
//		SqlSession session1=factory.openSession();
//		List<Object> list2=session.selectList("com.hdquan.mapper.LogMapper.selAll");
	System.out.println(list);
	System.out.println(list1);
		session.close();
	}
}
