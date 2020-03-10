package com.hdquan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hdquan.pojo.Log;

public interface LogMapper {
	List<Log> selByaccInaccOut(@Param("accIn") String accIn,@Param("accOut")String accOut);
	int upd(Log log);
	List<Log> selByLog(Log log);
	List<Log> selIn(List<Integer> list);
	int ins(List<Integer> list);
}
