package com.hdquan.mapper;

import java.util.List;

import com.hdquan.pojo.PageInfo;
import com.hdquan.pojo.Student;

public interface StudentMapper {
	List<Student> selByPage(PageInfo pi);
	long selCountByPageInfo(PageInfo pi);
}
