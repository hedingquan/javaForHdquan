package com.hdquan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.WaterElectricDao;
import com.hdquan.pojo.Account;
import com.hdquan.service.WaterElectricService;
@Service
@Transactional
public class WaterElectricServiceImpl implements WaterElectricService{

	@Autowired
	WaterElectricDao waterElectricDao;
	
	@Override
	public List<Account> allAccount() {
		// TODO Auto-generated method stub
		return waterElectricDao.allAccount();
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return waterElectricDao.getTotal();
	}

	@Override
	public List<Account> limitSearchAccount(String year, String season, String name1, String id1, String salaryNum,
			String building, String unit) {
		// TODO Auto-generated method stub
		return waterElectricDao.limitSearchAccount(year,season,name1,id1,salaryNum,building,unit);
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return waterElectricDao.addAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return waterElectricDao.updateAccount(account);
	}

	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		return waterElectricDao.getAccount(id);
	}

	@Override
	public List<Account> TeacherAccount() {
		// TODO Auto-generated method stub
		return waterElectricDao.TeacherAccount();
	}

	@Override
	public List<Account> OtherAccount() {
		// TODO Auto-generated method stub
		return waterElectricDao.OtherAccount();
	}

	@Override
	public List<Account> OtherlimitSearchAccount(String year, String month, String name1, String buildingName,
			String roomNum) {
		// TODO Auto-generated method stub
		return waterElectricDao.OtherlimitSearchAccount(year,month,name1,buildingName,roomNum);
	}

	@Override
	public Account deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return waterElectricDao.deleteAccount(account);
	}

}
