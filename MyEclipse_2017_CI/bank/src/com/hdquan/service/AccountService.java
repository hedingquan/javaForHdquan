package com.hdquan.service;

import java.io.IOException;

import com.hdquan.pojo.Account;
/*
 * accIn:收款账号
 * accOut：转账账号
 */
public interface AccountService {
	public static final int ACCOUNT_PASSWORD_NOT_MATH=1;//"账号和密码不匹配的状态码";//
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;//"余额不足";//
	int ACCOUNT_NAME_NOT_MATH=3;//"账号和姓名不匹配";//
	int ERROR=4;//"转账错误";
	int SUCCESS=5;//"转账成功";
	int transfer(Account accIn,Account accOut) throws IOException;
}
