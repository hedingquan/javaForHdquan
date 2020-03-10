package com.hdquan.service;

import java.io.IOException;

import com.hdquan.pojo.PageInfo;

public interface PageInfoServlet {
	PageInfo showpage (int pageSize,int pageNumber) throws IOException;
}
