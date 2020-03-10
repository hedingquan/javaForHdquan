package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Service.UserService;
import com.dao.UserDao;
import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	@Override
	public Object user(String user_name) {
		// TODO Auto-generated method stub
		return userDao.user(user_name);
	}

	@Override
	public boolean AddCuser(Cuser user) {
		// TODO Auto-generated method stub
		return userDao.AddCuser(user);
	}

	@Override
	public boolean AddAdmin(Admin user) {
		// TODO Auto-generated method stub
		return userDao.AddAdmin(user);
	}

	@Override
	public boolean AddBuser(Buser user) {
		// TODO Auto-generated method stub
		return userDao.AddBuser(user);
	}

	@Override
	public boolean AddUser(Object user) {
		// TODO Auto-generated method stub
		return userDao.AddUser(user);
	}

	@Override
	public boolean UpdateUser(Object user) {
		// TODO Auto-generated method stub
		return userDao.UpdateUser(user);
	}

	@Override
	public boolean UpdateCuser(Cuser user) {
		// TODO Auto-generated method stub
		return userDao.UpdateCuser(user);
	}

	@Override
	public boolean UpdateAdmin(Admin user) {
		// TODO Auto-generated method stub
		return userDao.UpdateAdmin(user);
	}

	@Override
	public boolean UpdateBuser(Buser user) {
		// TODO Auto-generated method stub
		return userDao.UpdateBuser(user);
	}

	@Override
	public Cuser getCuser(String user_ID) {
		// TODO Auto-generated method stub
		return userDao.getCuser(user_ID);
	}

	@Override
	public Admin getAdmin(String user_ID) {
		// TODO Auto-generated method stub
		return userDao.getAdmin(user_ID);
	}

	@Override
	public Buser getBuser(String user_ID) {
		// TODO Auto-generated method stub
		return userDao.getBuser(user_ID);
	}

	@Override
	public boolean DeleteCuser(Cuser user) {
		// TODO Auto-generated method stub
		return userDao.DeleteCuser(user);
	}

	@Override
	public boolean DeleteAdmin(Admin user) {
		// TODO Auto-generated method stub
		return userDao.DeleteAdmin(user);
	}

	@Override
	public boolean DeleteBuser(Buser user) {
		// TODO Auto-generated method stub
		return userDao.DeleteBuser(user);
	}

}
