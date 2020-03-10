package com.hdquan.service;

import com.hdquan.pojo.PageInfo;

public interface StudentService {
	PageInfo showPage(String sname,String tname,String pageSize,String pageNumber);
}
