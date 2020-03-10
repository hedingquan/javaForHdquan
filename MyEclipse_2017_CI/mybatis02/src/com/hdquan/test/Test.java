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

import com.hdquan.pojo.people;

public class Test {
	public static void main(String args[]) throws IOException
	{
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession(false);//此处省了false，若要ture，一般在最下面添置(手动提交)session.commit();
	//调用三个sql语句。
		session.selectList("a.b.c");
		session.selectList("a.b.d");
		
//		people peo=new people();
//		peo.setId(1);
		
//		Map<String,Object> map=new HashMap<>();
//		map.put("id",1);
//		map.put("name","张三");
		
		
//		int pageSize=0;
//		int pageNumber=0;
//		Map<String,Object> map=new HashMap<>();
//		map.put("pageSize",pageSize);//显示几个
//		map.put("pageStar",pageSize*(pageNumber)-1);//第几页
//		List<people> list=session.selectList("a.j.page",map);
//		System.out.println(list);

		
//		List<people> people=session.selectList("a.j.test",1);
//		System.out.println(people);
		
		
		people peo=new people();
		peo.setName("新增name");
		peo.setAge(88);
		try {
			int insert = session.insert("a.j.ins",peo);
			if(insert>0)
			{
				System.out.println("输出成功");
			}
			else
				System.out.println("输出失败");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			session.rollback();//不报错，直接事务回归原点
		}
		
		people p=new people();
//		p.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		try {
				int insert=session.insert("a.j.ins",p);
			if(insert>0)
			{System.out.println("成功");}
			else
				System.out.println("失败");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
			session.rollback();
		}
		
		session.commit();//即使提交了，也是事务原点初的时候
		session.close();
	}
}
