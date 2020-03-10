package com.hdquan.service;

import java.io.IOException;

import com.hdquan.pojo.Account;
/*
 * accIn:收款账号
 * accOut：转账账号
 */
public interface AccountService {
	public static final int ACCOUNT_PASSWORD_NOT_MATH=1;//"账号和密码不匹配的状态码";//
	int SUCCESS=5;//"转账成功";
	int transfer(Account accOut) throws IOException;
}
