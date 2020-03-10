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
	//�����Ҫ���ݶ������column="{"key"=����,"key"=����}" key�Զ��塣���ݹ�ȥ����Map���͵ģ�����String��object���͵���
	//��һ����ѯ�л�ȡ���ݹ����Ĳ��� #{key},���ݹ�ȥ����Map���͵ģ�����String��object���͵���
	//��MenuMapper�е�List<Menu> selByPid(Map<String,Object> map);
	//��һ����ѯpublic void select(Map<String,Object> map);
	@Select("select *,0 pid from users where username=#{username} and password=#{password}")
	Users selByUsers(Users users);
}
