package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ApplyDao;
import com.dao.PointDao;
import com.pojo.Apply;
import com.pojo.Point;

@Repository
public class PointDaoImpl implements PointDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Point AddPoint(Point point) {
		Session session = sessionFactory.getCurrentSession();
		session.save(point);
		return point;
	}

	@Override
	public boolean DeletePoint(Point point) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(point);
		return true;
	}

	@Override
	public Point getPoint(String point_id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Point.class, Integer.valueOf(point_id));
	}

	@Override
	public List<Point> getAllPoint() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Point").list();
	}

	@Override
	public List<Point> getMyPoint(String user_id1) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Point as p where p.user_id1='"+user_id1+"'").list();
	}


}
