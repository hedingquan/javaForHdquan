package com.dao;


import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;

public interface UserDao {
	
	public Object user(String user_name);
	
	public boolean AddUser(Object user);
	
	public boolean AddCuser(Cuser user);
	
	public boolean AddAdmin(Admin user);
	
	public boolean AddBuser(Buser user);
	
	public boolean UpdateUser(Object user);
	
	public boolean UpdateCuser(Cuser user);
	
	public boolean UpdateAdmin(Admin user);
	
	public boolean UpdateBuser(Buser user);
	
	public Cuser getCuser(String user_ID);
	
	public Admin getAdmin(String user_ID);
	
	public Buser getBuser(String user_ID);
	
	public boolean DeleteCuser(Cuser user);
	
	public boolean DeleteAdmin(Admin user);
	
	public boolean DeleteBuser(Buser user);
}
