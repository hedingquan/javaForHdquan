package com.hdquan.sericeImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.security.auth.login.Configuration;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import com.hdquan.pojo.people;
import com.hdquan.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{
	public List<people> show() throws IOException{
		InputStream is=Resources.getResourceAsStream("/configu/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);//构建者设计模式，当某些类sql比较复杂时，我们通过构建者快速地构建对象
		
//		XMLConfigBuilder parser=new XMLConfigBuilder(is);
//		org.apache.ibatis.session.Configuration cfg=parser.parse();
//		DefaultSqlSessionFactory factory2=new DefaultSqlSessionFactory(cfg);
		
		SqlSession session=factory.openSession();
		List<people> list=session.selectList("com.hdquan.mapper.PeopleMapper.selAll");
		
		session.close();
		return list;
	}
	
}
