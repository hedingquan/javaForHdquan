package com.hdquan.action;

import java.util.Arrays;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UserAction implements Action{

	@Override
	public String execute() throws Exception {
		/*(1)ActionContext context = ActionContext.getContext();
		HttpParameters map = context.getParameters();
		//调用方法得到表单数据
		//key是表单输入项name属性值，value是输入值
		Set<String> keys = map.keySet();
		for(String key:keys){
			Parameter obj=map.get(key);
			System.out.println(obj.toString());
		}
		return SUCCESS;*/
		HttpServletRequest request = ServletActionContext.getRequest();
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 return SUCCESS;
	}

}
