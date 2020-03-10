package com.hdquan.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.BuildingDao;
import com.hdquan.pojo.Account;
import com.hdquan.pojo.Building;
import com.hdquan.pojo.Room;
import com.hdquan.pojo.Unit;

@Repository
public class BuildingDaoImpl implements BuildingDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Building> allBuilding() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from building b";
		return session.createQuery(hql).list();
	}

	@Override
	public List<Building> limitBuilding(String buildingName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from building b where 1=1";
		if(buildingName!=null&&buildingName.trim()!=""){hql+=" and b.buildingName like '%"+buildingName.trim()+"%'";}
		return session.createQuery(hql).list();
	}

	@Override
	public Building getBuilding(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Building.class, id);
	}

	@Override
	public Building updateBuilding(Building building) {
		Session	session=sessionFactory.getCurrentSession();
		session.update(building);
		return building;
	}

	@Override
	public Building addBuilding(Building building) {
		Session session = sessionFactory.getCurrentSession();
		session.save(building);
		return building;
	}

	@Override
	public Building deleteBuilding(Building building) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(building);
		return building;
	}

	@Override
	public List<Building> BuildingName() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from building b where 1=1 and b.buildingName like '%校区%'";
		return session.createQuery(hql).list();
	}

	@Override
	public List<Unit> unitName() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from unit u";
		return session.createQuery(hql).list();
	}

	@Override
	public List<Building> OtherBuildingName() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from building b where 1=1 and b.buildingName not like '%校区%'";
		return session.createQuery(hql).list();
	}

	@Override
	public List<Room> Rooms(String buildingName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select b.room from building b where 1=1 and b.buildingName  like '"+buildingName+"%'";
		return session.createQuery(hql).list();
	}

	@Override
	public Building getBuilding(String buildingName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from building b where b.buildingName  like '"+buildingName+"%'";
		if(session.createQuery(hql).list().size()>0)
		{
			return (Building) session.createQuery(hql).list().get(0);			
		}else{
			return null;
		}
	}

	@Override
	public Room getRoom(String roomNum) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from room r where r.roomNum  like '"+roomNum+"%'";
		if(session.createQuery(hql).list().size()>0)
		{
			return (Room) session.createQuery(hql).list().get(0);
		}else{
			return null;
		}
	}

	@Override
	public Unit getUnit(String uName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from unit u where u.uName  like '"+uName+"%'";
		if(session.createQuery(hql).list().size()>0)
		{
			return (Unit) session.createQuery(hql).list().get(0);
		}else{
			return null;
		}
	}
}