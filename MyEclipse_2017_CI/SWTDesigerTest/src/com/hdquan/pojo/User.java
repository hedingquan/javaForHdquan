package com.hdquan.pojo;

import java.util.List;

import com.hdquan.dao.UserDao;

public class User {
	
	public static String ID;
	public static String userName;
	public static String password;
	public static String sex;
	public static String userPhone;
	static UserDao userDao;
	public static String getID() {
		return ID;
	}
	public static void setID(String id) {
		ID = id;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		User.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	public static String getSex() {
		return sex;
	}
	public static void setSex(String sex) {
		User.sex = sex;
	}
	public static String getUserPhone() {
		return userPhone;
	}
	public static void setUserPhone(String userPhone) {
		User.userPhone = userPhone;
	}
	public  static void getAllInfo(String userName,String password)
	{
		try {
		    List<User> userList = userDao.query();
	        for (User user1 : userList){
	      String results[][]=new String[userList.size()][5];
			for(int i = 0; i < userList.size(); i++) {		
//					results[i][0] = user1.getUserName();
//					results[i][1] = user1.getPassword();
//					results[i][2] = user1.getSex();
//					results[i][3] = user1.getUserPhone();
//					results[i][4] = user1.getID();
			if(userName.equals(user1.getUserName())&&password.equals(user1.getPassword()))
				{	ID= user1.getID();
					sex = user1.getSex();	
					userPhone=user1.getUserPhone();
					System.out.println(ID+""+sex+"");
					break;
				}
			}
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
