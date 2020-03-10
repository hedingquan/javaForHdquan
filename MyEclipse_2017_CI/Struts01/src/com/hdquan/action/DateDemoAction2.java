package com.hdquan.action;

import com.hdquan.pojo.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


//使用模型驱动获取表单数据
public class DateDemoAction2 extends ActionSupport implements ModelDriven<Users>{
	private Users user=new Users();
	
	@Override
	public String execute() throws Exception {
		return NONE;
	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
