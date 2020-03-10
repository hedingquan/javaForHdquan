package com.hdquan.filter;
/*
 * 最开始是由Spring框架提出的，整合Hibernate框架是使用的OpenSessionInView
 * 
 */
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.util.mybatisUtil;
@WebFilter("/*")
public class OpenSessionInView implements Filter{

//每次过滤器执行的方法
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
//		InputStream is=Resources.getResourceAsStream("mybatis.xml");
//		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
//		SqlSession session=factory.openSession();
		SqlSession session = mybatisUtil.getSession();
	try {
		filterchain.doFilter(servletrequest, servletresponse);
		session.commit();
	} catch (Exception e) {
	session.rollback();
		e.printStackTrace();
	}finally
	{
		mybatisUtil.closeSession();
	}
	
//		session.commit();
//		session.close();
	}
////初始化方法
//public void init(FilterConfig filterConfig) throws ServletException {
//	// TODO Auto-generated method stub
//	Filter.super.init(filterConfig);
//}
////销毁的时候执行
//	public void destroy() {
//		// TODO Auto-generated method stub
//		Filter.super.destroy();
//	}
}
