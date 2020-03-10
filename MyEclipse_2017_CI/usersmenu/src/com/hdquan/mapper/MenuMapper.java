package com.hdquan.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hdquan.pojo.Menu;

public interface MenuMapper {
	//select mid from users_menu where uid=?
	//select * from menu where id in (select mid from users_menu where uid=?) and pid=?
	@Results(value={
			@Result(id=true,property="id",column="id"),
			@Result(property="name",column="name"),
			@Result(property="pid",column="pid"),
			@Result(property="children",many=@Many(select="selByPid"),column="{uid=uid,pid=id}"),
	})
	@Select("select *,#{uid} uid from menu where id in (select mid from users_menu where uid=#{uid}) and pid=#{pid}")
	List<Menu> selByPid(Map<String,Object> map);
	//执行顺序为23-》22-》16——21-》(23——》22-——》16——21)无限递归
}
