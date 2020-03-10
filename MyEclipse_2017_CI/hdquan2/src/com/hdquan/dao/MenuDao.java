package com.hdquan.dao;

import java.math.BigInteger;
import java.util.List;

import com.hdquan.pojo.Menu;

public interface MenuDao {

	public List<Menu> tree(Menu menu);

	public Long countChildren(String id);
}
