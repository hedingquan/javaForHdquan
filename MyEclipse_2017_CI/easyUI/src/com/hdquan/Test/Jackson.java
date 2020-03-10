package com.hdquan.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdquan.pojo.Person;

public class Jackson {
	//java对象转为json字符串
	@Test
	public void test() throws IOException
	{
		Person p=new Person();
		p.setName("张三");
		p.setGender("男");
		p.setAge(23);
		
		//创建jackson的核心对象，ObjectMapper
		ObjectMapper mapper=new ObjectMapper();
		
		//
	/*	转换方法：
			writeValue(参数1,obj)
				参数1：
					File：将obj对象转换为JSON字符串，并保存到指定的文件中
					Writer:将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
					outputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
			writeValueAsString(obj):将对象转为json字符串
		*/
		String json = mapper.writeValueAsString(p);
		//将数据写到d：//a.txt文件中
		//mapper.writeValue(new File("d://a.txt"), p);
		System.out.println(json);
	}
	
	@Test
	public void test2() throws IOException
	{
		Person p=new Person();
		p.setName("张三");
		p.setGender("男");
		p.setAge(23);
		p.setBirthday(new Date());
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(p);
		System.out.println(json);
	}
	
	@Test
	public void test3() throws IOException
	{
		Person p1=new Person();
		p1.setName("张三");
		p1.setGender("男");
		p1.setAge(23);
		p1.setBirthday(new Date());
		
		Person p2=new Person();
		p2.setName("张三");
		p2.setGender("男");
		p2.setAge(23);
		p2.setBirthday(new Date());
		
		Person p3=new Person();
		p3.setName("张三");
		p3.setGender("男");
		p3.setAge(23);
		p3.setBirthday(new Date());
		
		
		//创建List集合
		List<Person> ps=new ArrayList<Person>();
		ps.add(p1);
		ps.add(p2);
		ps.add(p3);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(ps);
		System.out.println(json);
	}
	
	@Test
	public void test4() throws IOException
	{
		//创建Map集合
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "李四");
		map.put("age", 23);
		map.put("gender", "男");
		
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		System.out.println(json);
	}
	
	//json字符串转为java对象
	@Test
	public void test5() throws IOException
	{
		//初始化json字符串
		String json="{\"gender\":\"男\",\"name\":\"李四\",\"age\":23}";
		
		ObjectMapper mapper=new ObjectMapper();
		Person person = mapper.readValue(json, Person.class);
		System.out.println(person);
	}
}
