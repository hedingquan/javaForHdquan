package com.hdquan.service;

import java.io.IOException;

import com.hdquan.pojo.PageInfo;

public interface LogService {
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
