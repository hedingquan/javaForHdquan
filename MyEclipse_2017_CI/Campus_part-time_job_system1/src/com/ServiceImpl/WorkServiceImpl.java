package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Service.UserService;
import com.Service.WorkService;
import com.dao.UserDao;
import com.dao.WorkDao;
import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;
import com.pojo.Work;


@Service
@Transactional
public class WorkServiceImpl implements WorkService{

	@Autowired
	WorkDao workDao;
	
	@Override
	public Work AddWork(Work work) {
		// TODO Auto-generated method stub
		return workDao.AddWork(work);
	}

	@Override
	public boolean UpdateWork(Work work) {
		// TODO Auto-generated method stub
		return workDao.UpdateWork(work);
	}

	@Override
	public Work getWork(String work_id) {
		// TODO Auto-generated method stub
		return workDao.getWork(work_id);
	}

	@Override
	public boolean DeleteWork(Work work) {
		// TODO Auto-generated method stub
		return workDao.DeleteWork(work);
	}

	@Override
	public List<Work> AllWork() {
		// TODO Auto-generated method stub
		return workDao.AllWork();
	}

	@Override
	public List<Work> MyWork(String user_ID) {
		// TODO Auto-generated method stub
		return workDao.MyWork(user_ID);
	}

	@Override
	public Work getWorkBywork_title(String work_title) {
		// TODO Auto-generated method stub
		return workDao.getWorkBywork_title(work_title);
	}

}
