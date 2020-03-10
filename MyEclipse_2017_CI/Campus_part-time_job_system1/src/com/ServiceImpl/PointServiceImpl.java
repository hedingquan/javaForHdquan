package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Service.ApplyService;
import com.Service.PointService;
import com.Service.UserService;
import com.Service.WorkService;
import com.dao.ApplyDao;
import com.dao.PointDao;
import com.dao.UserDao;
import com.dao.WorkDao;
import com.pojo.Admin;
import com.pojo.Apply;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.Point;
import com.pojo.User;
import com.pojo.Work;


@Service
@Transactional
public class PointServiceImpl implements PointService{

	@Autowired
	PointDao pointDao;

	@Override
	public Point AddPoint(Point point) {
		// TODO Auto-generated method stub
		return pointDao.AddPoint(point);
	}

	@Override
	public boolean DeletePoint(Point point) {
		// TODO Auto-generated method stub
		return pointDao.DeletePoint(point);
	}

	@Override
	public Point getPoint(String point_id) {
		// TODO Auto-generated method stub
		return pointDao.getPoint(point_id);
	}

	@Override
	public List<Point> getAllPoint() {
		// TODO Auto-generated method stub
		return pointDao.getAllPoint();
	}

	@Override
	public List<Point> getMyPoint(String user_id1) {
		// TODO Auto-generated method stub
		return pointDao.getMyPoint(user_id1);
	}


}
