package com.hdquan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.WaterElectricDao;
import com.hdquan.pojo.Account;
@Repository
public class WaterElectricDaoImpl implements WaterElectricDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Account> allAccount() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from account u ";
		return session.createQuery(hql).list();
	}

	@Override
	public Long getTotal() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from account";
		return (Long)session.createQuery(hql).uniqueResult();
	}

	@Override
	public List<Account> limitSearchAccount(String year,String season, String name1, String id1, String salaryNum, String building,
			String unit) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select a from account a where 1=1 and a.room.building.buildingName like '%校区%'";
		if(year!=null&&year.trim()!=""){hql+=" and a.Season like '%"+year.trim()+season+"%'";}
		if(season!=null&&season.trim()!=""&&year==null&&year.trim()==""){hql+=" and a.Season like '%"+season.trim()+"%'";}
		if(name1!=null&&name1.trim()!=""){hql+=" and a.Name like '%"+name1.trim()+"%'";}
		if(id1!=null&&id1.trim()!=""){hql+=" and a.id like '%"+id1.trim()+"%'";}
		if(salaryNum!=null&&salaryNum.trim()!=""){hql+=" and a.salaryNum like '%"+salaryNum.trim()+"%'";}
		if(building!=null&&building.trim()!=""){hql+=" and a.room.building.buildingName like '%"+building.trim()+"%'";}
		if(unit!=null&&unit.trim()!=""){hql+=" and a.unit.uName like '%"+unit.trim()+"%'";}
		return session.createQuery(hql).list();
	}
	
	@Override
	public List<Account> OtherlimitSearchAccount(String year, String month, String name1, String buildingName,
			String roomNum) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select a from account a where 1=1 and a.room.building.buildingName not like '%校区%'";
		if(year!=null&&year.trim()!=""){hql+=" and a.Season like '%"+year.trim()+month+"%'";}
		if(month!=null&&month.trim()!=""&&year==null&&year.trim()==""){hql+=" and a.Season like '%"+month.trim()+"%'";}
		if(name1!=null&&name1.trim()!=""){hql+=" and a.Name like '%"+name1.trim()+"%'";}
		if(buildingName!=null&&buildingName.trim()!=""){hql+=" and a.room.building.buildingName like '%"+buildingName.trim()+"%'";}
		if(roomNum!=null&&roomNum.trim()!=""){hql+=" and a.room.roomNum like '%"+roomNum.trim()+"%'";}
		return session.createQuery(hql).list();
	}
	
	@Override
	public Account addAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		Session	session=sessionFactory.getCurrentSession();
		session.update(account);
		return account;
	}
	
	public Account getAccount(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Account.class, id);
	}

	@Override
	public List<Account> TeacherAccount() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select a from account a where 1=1 and a.room.building.buildingName like '%校区%'";
		return session.createQuery(hql).list();
	}

	@Override
	public List<Account> OtherAccount() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select a from account a where 1=1 and a.room.building.buildingName not like '%校区%'";
		return session.createQuery(hql).list();
	}

	@Override
	public Account deleteAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(account);
			return account;
	}

}
