package com.hdquan.dao;

import com.hdquan.pojo.User;

public interface UserDao {

	User queryByNameAndPwd(User user);

}
