package com.hdquan.dao;

import java.util.List;

import com.hdquan.pojo.ProvisionalAuthorization;
import com.hdquan.pojo.User;



public interface ProvisionalAuthorizationDao {
	
	public List<ProvisionalAuthorization> getRoles(int page,int rows,String sort,String order,User user,ProvisionalAuthorization provisionalAuthorization);
	
	public Long getTotal();
	
	public ProvisionalAuthorization insertRole(ProvisionalAuthorization provisionalAuthorization);

	public ProvisionalAuthorization deleteRole(String id);
	
	public ProvisionalAuthorization updateRole(ProvisionalAuthorization provisionalAuthorization);

	public ProvisionalAuthorization getRole(String usercode);
}
