package com.hdqu.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class BeanListener implements HttpSessionBindingListener{

	//绑定
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("绑定：Bean对象（将Bean对象增加到session域中）,绑定的对象："+this+",sessionId:"+event.getSession().getId());
	}
	//解绑
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("解绑：Bean对象（将Bean对象从session域中删除）,解绑的对象："+this+",sessionId:"+event.getSession().getId());

	}

}
