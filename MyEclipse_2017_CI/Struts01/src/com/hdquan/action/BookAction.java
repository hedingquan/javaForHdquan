package com.hdquan.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BookAction extends ActionSupport{

	
	public BookAction() {
	System.out.println("每次访问action时候，都会创建action对象,在每个action对象里面都会有一个值栈对象");
	}
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();//获取得到值栈对象
		return NONE;
	}
	public String add(){
		return NONE;
	}
	public String update(){
		return NONE;
	}
	
	public String list()
	{
		//获取到request对象的方法
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", "hibernate查询的表单数据");
	
//		if("adimin".equals(username) && "250".equals(password)){}
		
		return "list";
	}
	
	
}
