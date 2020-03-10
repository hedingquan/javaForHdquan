package com.dao;

import java.util.List;

import com.pojo.Apply;
import com.pojo.Work;

public interface ApplyDao {
	
	public Apply AddApply(Apply apply);
	
	public boolean UpdateApply(Apply apply);
	
	public Apply getApply(String apply_id);
	
	public boolean DeleteApply(Apply apply);
	
	public List<Apply> getApplyUser(String work_id);
	
	public List<Apply> getMyApply(String user_id);
	
	public List<Apply> getAllApply();
	
	public List<Apply> getToBeAuditedApply(String work_id);
}
