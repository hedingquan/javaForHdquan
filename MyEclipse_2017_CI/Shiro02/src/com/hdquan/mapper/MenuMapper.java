package com.hdquan.mapper;

import java.util.List;

import com.hdquan.pojo.Menu;

public interface MenuMapper {
	List<Menu> selByPid(int pid);
}
