package com.hdquan.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.pojo.flower;

public class test {
	public static void main(String args[]) throws IOException
	{

		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();
		List<flower> list=session.selectList("a.b.selAll");
		for(flower flower:list)
		{
			System.out.println(flower.toString());
		}
		
	}
}
