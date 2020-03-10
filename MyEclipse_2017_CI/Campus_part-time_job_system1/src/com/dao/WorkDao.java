package com.dao;

import java.util.List;

import com.pojo.Work;

public interface WorkDao {
	
	public Work AddWork(Work work);
	
	public boolean UpdateWork(Work work);
	
	public Work getWork(String work_id);
	
	public boolean DeleteWork(Work work);
	
	public List<Work> AllWork();
	
	public List<Work> MyWork(String user_ID);
	
	public Work getWorkBywork_title(String work_title);
}
