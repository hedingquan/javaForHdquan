package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.AdressDao;
import com.hdquan.pojo.Adress;
import com.hdquan.pojo.User;
import com.hdquan.service.AdressService;

@Service
@Transactional
public class AdressServiceImpl implements AdressService{

	@Autowired
	AdressDao adressDao;

	@Override
	public int insertAdress(Adress adress) {
		// TODO Auto-generated method stub
		return adressDao.insertAdress(adress);
	}

	@Override
	public Adress deleteAdress(String ids) {
		// TODO Auto-generated method stub
		return adressDao.deleteAdress(ids);
	}

	@Override
	public List<Adress> getAdress(Adress adress,User k) {
		// TODO Auto-generated method stub
		return adressDao.getAdress(adress,k);
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return adressDao.getTotal();
	}

	@Override
	public List<Adress> getAdressByroles(String userName) {
		// TODO Auto-generated method stub
		return adressDao.getAdressByroles(userName);
	}

	@Override
	public Adress updateAdress(Adress adress) {
		// TODO Auto-generated method stub
		return adressDao.updateAdress(adress);
	}

	

}
