package com.hdquan.util;
/*
 * 工具类
 */
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisUtil {
	
	private static SqlSessionFactory  factory;//下面是静态代码块，使用这里也使用静态的
	private static ThreadLocal<SqlSession> tl=new ThreadLocal<>();
	static{
		try {
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取SqlSession的方法
	public static SqlSession getSession(){
		SqlSession session=tl.get();
		if(session==null){
		tl.set(factory.openSession());
		}
		return tl.get();
										}
	public static void closeSession(){
	SqlSession sqlSession = tl.get();
	if(sqlSession!=null)
	{
		sqlSession.close();
	}
				tl.set(null);						}
}