package com.hdquan.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hdquan.mapper.StudentMapper;
import com.hdquan.mapper.teacherMapper;
import com.hdquan.pojo.PageInfo;
import com.hdquan.pojo.Student;
import com.hdquan.service.StudentService;
import com.hdquan.util.mybatisUtil;

public class StudentServiceImpl implements StudentService{
	public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) 
	{	int pageSize=2;
			if(pageSizeStr!=null&&pageSizeStr.equals(""))
					{
				pageSize=Integer.parseInt(pageSizeStr);
					}
		int pageNumber=1;
			if(pageNumberStr!=null&&pageNumberStr.equals(""))
			{
				pageNumber=Integer.parseInt(pageNumberStr);
			}
			SqlSession session = mybatisUtil.getSession();
			StudentMapper StudentMapper = session.getMapper(StudentMapper.class);
			PageInfo pi=new PageInfo();
			//放入全部信息
			pi.setSname(sname);
			pi.setTname(tname);
			pi.setPageStart((pageNumber-1)*pageSize);
			pi.setPageNumber(pageNumber);
			pi.setPageSize(pageSize);
			List<Student> list = StudentMapper.selByPage(pi);
			//查询出每个学生对应的老师信息
			teacherMapper teachermapper = session.getMapper(teacherMapper.class);
		
			for(Student student:list)
			{
				student.setTeacher(teachermapper.selById(student.getTid()));
			}
			
			pi.setList(list);
			long count = StudentMapper.selCountByPageInfo(pi);
			pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pi;
	}
	
}
