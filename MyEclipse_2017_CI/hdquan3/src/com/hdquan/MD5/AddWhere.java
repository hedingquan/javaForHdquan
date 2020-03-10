package com.hdquan.MD5;

import java.util.List;

import com.hdquan.pojo.User;

public class AddWhere {
	public static String addWhere(User user,String hql,List<Object> values)
	{
		if(user.getRealName()!=null&&!user.getRealName().trim().equals(""))
		{
			hql+=" and u.realName like '%"+user.getRealName().trim()+"%'";
		}
		if(user.getBirthday()!=null&&!user.getBirthday().equals(""))
		{
			hql+=" and u.birthday='"+user.getBirthday()+"'";
			values.add(user.getBirthday());
		}
		if(user.getUserid()!=null&&!user.getUserid().trim().equals(""))
		{
			hql+=" and u.userid like '%"+user.getUserid().trim()+"%'";
			values.add(user.getUserid());
		}
		if(user.getSex()!=null&&!user.getSex().trim().equals(""))
		{
			hql+=" and u.sex like '%"+user.getSex().trim()+"%'";
			values.add(user.getSex());
		}
		if(user.getPincodes()!=null&&!user.getPincodes().trim().equals(""))
		{
			hql+=" and u.pincodes like '%"+user.getPincodes().trim()+"%'";
			values.add(user.getPincodes());
		}
		if(user.getTelephone()!=null&&!user.getTelephone().trim().equals(""))
		{
			hql+=" and u.telephone like '%"+user.getTelephone().trim()+"%'";
			values.add(user.getTelephone());
		}
		if(user.getFixedPhone()!=null&&!user.getFixedPhone().trim().equals(""))
		{
			hql+=" and u.fixedPhone like '%"+user.getFixedPhone().trim()+"%'";
			values.add(user.getFixedPhone());
		}
		if(user.geteMail()!=null&&!user.geteMail().trim().equals(""))
		{
			hql+=" and u.eMail like '%"+user.geteMail().trim()+"%'";
			values.add(user.geteMail());
		}
		if(user.getQq()!=null&&!user.getQq().trim().equals(""))
		{
			hql+=" and u.qq like '%"+user.getQq().trim()+"%'";
			values.add(user.getQq());
		}
		return hql;
		
	}
}
