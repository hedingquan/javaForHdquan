package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Service.ApplyService;
import com.Service.UserService;
import com.Service.WorkService;
import com.dao.ApplyDao;
import com.dao.UserDao;
import com.dao.WorkDao;
import com.pojo.Admin;
import com.pojo.Apply;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;
import com.pojo.Work;


@Service
@Transactional
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	ApplyDao applyDao;

	@Override
	public Apply AddApply(Apply apply) {
		// TODO Auto-generated method stub
		return applyDao.AddApply(apply);
	}

	@Override
	public boolean UpdateApply(Apply apply) {
		// TODO Auto-generated method stub
		return applyDao.UpdateApply(apply);
	}

	@Override
	public Apply getApply(String apply_id) {
		// TODO Auto-generated method stub
		return applyDao.getApply(apply_id);
	}

	@Override
	public boolean DeleteApply(Apply apply) {
		// TODO Auto-generated method stub
		return applyDao.DeleteApply(apply);
	}

	@Override
	public List<Apply> getApplyUser(String work_id) {
		// TODO Auto-generated method stub
		return applyDao.getApplyUser(work_id);
	}

	@Override
	public List<Apply> getMyApply(String user_id) {
		// TODO Auto-generated method stub
		return applyDao.getMyApply(user_id);
	}

	@Override
	public List<Apply> getAllApply() {
		// TODO Auto-generated method stub
		return applyDao.getAllApply();
	}

	@Override
	public List<Apply> getToBeAuditedApply(String work_id) {
		// TODO Auto-generated method stub
		return applyDao.getToBeAuditedApply(work_id);
	}

}
