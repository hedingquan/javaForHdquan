package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Adress;
import com.hdquan.pojo.User;

public interface AdressService {

	public int insertAdress(Adress adress);
	
	public Adress deleteAdress(String ids);
	
	public List<Adress> getAdress(Adress adress,User k);
	
	public List<Adress> getAdressByroles(String userName);
	
	public Long getTotal();
	
	public Adress updateAdress(Adress adress);
}
