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

import com.hdquan.mapper.LogMapper;
import com.hdquan.pojo.Log;


public class Test {
	public static void main(String args[]) throws IOException
	{
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ps.addBatch();
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession(ExecutorType.BATCH);
		Scanner input=new Scanner(System.in);
		System.out.println("请输入转账账号");
		String accIn=input.nextLine();
		System.out.println("请输入收款账号");
		String accOut=input.nextLine();
	
//		LogMapper logMapper = session.getMapper(LogMapper.class);
//		List<Log> list = logMapper.selByaccInaccOut(accOut,accIn);
//		System.out.println(list);
		
	LogMapper logMapper = session.getMapper(LogMapper.class);
//		Log log=new Log();
//		log.setId(1);
//		log.setAccOut(accOut);
//		log.setAccIn(accIn);
//		int index = logMapper.upd(log);
//		System.out.println(index);
		
//	
//		Log log=new Log();
//		log.setAccIn(accIn);
//		log.setAccOut(accOut);
//		List<Log> list = logMapper.selByLog(log);
//		System.out.println(list.toString());
//	
//		logMapper.upd(new Log());
	
//	List<Integer> list=new ArrayList<>();
//	list.add(1);
//	list.add(2);
//	List<Log> selIn = logMapper.selIn(list);
//	System.out.println(selIn);
	
	List<Integer> list=new ArrayList<>();
	for(int i=0;i<100;i++)
	{
		list.add(i);
	}
	int ins = logMapper.ins(list);
//		session.commit();
		session.close();
		input.close();
	}
}
