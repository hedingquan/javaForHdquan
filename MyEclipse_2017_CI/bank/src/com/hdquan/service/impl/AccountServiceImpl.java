package com.hdquan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.hdquan.pojo.Account;
import com.hdquan.pojo.Log;
import com.hdquan.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		//先判断账号和密码是否正确
		Account accOutSelect=session.selectOne("com.hdquan.mapper.AccountMapper.selByAccnoPwd",accOut);//直接一个账号传进去
		if(accOutSelect!=null)
		{if(accOutSelect.getBalance()>=accOut.getBalance())
			{Account accInSelect=session.selectOne("com.hdquan.mapper.AccountMapper.selByAccnoName",accIn);
				if(accInSelect!=null)
				{	accIn.setBalance(accIn.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index=session.update("com.hdquan.mapper.AccountMapper.updBanlanceAccount",accOut);
					index+=session.update("com.hdquan.mapper.AccountMapper.updBanlanceAccount",accIn);
					if(index==2)
					{	//日志表记录
						Log log=new Log();
						log.setAccIn(accIn.getAccNO());
						log.setAccOut(accOut.getAccNO());
						log.setMoney(accIn.getBalance());
						session.insert("com.hdquan.mapper.LogMapper.insLog",log);
						//日志文件记录
						Logger logger=Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut()+"给"+log.getAccIn()+"在"+new Date().toLocaleString()+"转了"+log.getMoney());
						session.commit();
						session.close();
						return SUCCESS;
					}
					else
					{
						session.rollback();
						session.close();
						return ERROR;
					}
				}
				else
				{return ACCOUNT_NAME_NOT_MATH;}
			}
			else 
			{
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else
		{//账号和密码不正确
			return ACCOUNT_PASSWORD_NOT_MATH;
		}
	}
	
}
