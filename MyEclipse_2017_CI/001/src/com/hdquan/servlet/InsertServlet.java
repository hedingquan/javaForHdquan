package com.hdquan.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdquan.pojo.flower;
@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		List<flower> list=session.selectList("a.b.selAll");
		//要做什么操作 就用什么方法,查询
//		for(flower flower:list)
//		{
//			System.out.println(flower.toString());
//		}
		
		
//		int count=session.selectOne("a.b.selById");
//		System.out.println(count);

	Map<Object,Object> map=session.selectMap("a.b.c","name");
	System.out.println(map);
	session.close();
	

		
			res.sendRedirect("show");
	res.sendRedirect("add.jsp");
	}
}
