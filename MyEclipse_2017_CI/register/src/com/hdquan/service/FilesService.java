package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Files;
import com.hdquan.pojo.Users;

public interface FilesService {
	List<Files> show();
	int updCount(int id,Users users,String name);
}
