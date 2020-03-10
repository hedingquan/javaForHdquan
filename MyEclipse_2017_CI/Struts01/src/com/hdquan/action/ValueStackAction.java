package com.hdquan.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hdquan.pojo.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport{
	
	private String name="hdquan";	
	
	private Users user=new Users();
	public String getName() {
		return name;
	}
	
	public Users getUser() {
		return user;
	}

/*	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();//获取得到值栈对象
		valueStack.set("username", "name");//第一种方式放数据
		valueStack.push("abcd");
		user.setUsername("123");
		user.setPassword("123");
		return NONE;
	}*/
	
	@Override
	public String execute() throws Exception {
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setAttribute("req", "requestValue");
	return "success";
	}
}
