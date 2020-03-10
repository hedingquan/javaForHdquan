package com.hdquan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.hdquan.pojo.Menu;

public interface MenuMapper {
	@Select("select * from menu where id in (select mid from role_menu where rid=#{rid})")
	List<Menu> selByPid(int rid);
}
