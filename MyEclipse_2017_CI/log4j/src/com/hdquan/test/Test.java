package com.hdquan.test;

import org.apache.log4j.Logger;//是apache的包

public class Test {
	public static void main(String args[])
	{
		Logger logger=Logger.getLogger(Test.class);
		logger.debug("这是调试信息");
		logger.info("这是信息");
		
		/*if(logger.isDebugEnabled())
		{
			logger.debug("debug:"+name);
		}*/
		
		try {
			int in=5/0;
			
		} catch (Exception e) {
	logger.error(e.getMessage());
/*	e.printStackTrace();
	logger.error(e.getMessage(),e.getCause());
	throw new XXX;*/
		}
	}
}
