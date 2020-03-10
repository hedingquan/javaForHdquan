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

import com.hdquan.pojo.Student;
import com.hdquan.pojo.Teacher;



public class Test {
	public static void main(String args[]) throws IOException
	{
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		List<Teacher> list=session.selectList("com.hdquan.mapper.TeacherMapper.selAll1");
		for(Teacher teacher:list)
		{
			System.out.println(teacher);
		}
//		System.out.println(list);
		session.close();
	}
}
