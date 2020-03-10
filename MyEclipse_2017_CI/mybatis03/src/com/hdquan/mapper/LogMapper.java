package com.hdquan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdquan.pojo.Log;

public interface LogMapper {
	List<Log> selAll();
	//List<Log> selByAccInAccOut(String accIn,String accOut);
	List<Log> selByAccInAccOut(@Param("accIn") String accIn,@Param("accOut") String accOut);
}
