package com.hdquan.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hdquan.pojo.Menu;
import com.hdquan.pojo.Users;


public interface UsersMapper {

@Results(value={
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(property="menus",many=@Many(select="com.hdquan.mapper.MenuMapper.selByPid"),column="{uid=id,pid=pid}")
//		@Results(property="menus",many=@Many(select=""),column="{"abc"=id,"bbe"=lie}")
		
})
	//如果需要传递多个参数column="{"key"=列名,"key"=列名}" key自定义。传递过去的是Map类型的，不是String和object类型的了
	//另一个查询中获取传递过来的参数 #{key},传递过去的是Map类型的，不是String和object类型的了
	//在MenuMapper中的List<Menu> selByPid(Map<String,Object> map);
	//另一个查询public void select(Map<String,Object> map);
	@Select("select *,0 pid from users where username=#{username} and password=#{password}")
	Users selByUsers(Users users);
}
