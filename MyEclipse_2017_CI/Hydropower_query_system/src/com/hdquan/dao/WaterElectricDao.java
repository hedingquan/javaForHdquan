package com.hdquan.dao;

import java.util.List;

import com.hdquan.pojo.Account;

public interface WaterElectricDao {
	public List<Account> allAccount();
	
	public Long getTotal();
	
	public List<Account> limitSearchAccount(String year,String season, String name1, String id1, String salaryNum, String building,String unit);

	public List<Account> OtherlimitSearchAccount(String year, String month, String name1,String buildingName, String roomNum);
	
	public Account addAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public Account getAccount(int id);
	
	public List<Account> TeacherAccount();
	
	public List<Account> OtherAccount();
	
	public Account deleteAccount(Account account);
}
