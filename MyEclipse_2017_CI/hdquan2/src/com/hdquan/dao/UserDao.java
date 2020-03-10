package com.hdquan.dao;

import java.util.List;

import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface UserDao {

	User login (User user);
	 
	List<User> getUser();
	
	List<User> getUser(int page,int rows,Object...param);
	
	public List<User> getUsers(int page,int rows,String sort,String order,User user);
	
	User queryByNameAndPwd(String usercode);
	
	User findUserByUserId(int id);
	
	List<Object[]> findUserDepartmentByName(String realName);//�����û�������ѯ�û���Ϣ���ɷ��ض���
	
	List<Role> findUserRoleByName(String realName);//���������鿴��ɫ
	
	List<Permission> findUserPermissionByName(String realName);//���������鿴Ȩ��
//	activeUser UserByUserCode(String userCode);
	
	User insertUser(User user);//����û�
	
	boolean deleteUser(String userids);//ɾ���û�
	
	User updateUser(User user);//�����û�
	
	Long getTotal();//�û�����

}
