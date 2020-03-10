package com.hdquan.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.pojo.flower;

public class Test {
	public static void main(String args[]) throws IOException
	{

		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);//构建者设计模式，当某些类sql比较复杂时，我们通过构建者快速地构建对象
		//本应该是SqlSessionFactoryBuilder(Configuration Configuration)
		//生产SqlSession
		SqlSession session=factory.openSession();//就是生产sql
		List<flower> list=session.selectList("a.b.selAll");
		//要做什么操作 就用什么方法,查询
		for(flower flower:list)
		{
			System.out.println(flower.toString());
		}
		
		
//		int count=session.selectOne("a.b.selById");
//		System.out.println(count);

//	Map<Object,Object> map=session.selectMap("a.b.c","name");
//	System.out.println(map);
	session.close();
	
	}
}
