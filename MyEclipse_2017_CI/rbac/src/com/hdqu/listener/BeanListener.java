package com.hdqu.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class BeanListener implements HttpSessionBindingListener{

	//��
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("�󶨣�Bean���󣨽�Bean�������ӵ�session���У�,�󶨵Ķ���"+this+",sessionId:"+event.getSession().getId());
	}
	//���
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("���Bean���󣨽�Bean�����session����ɾ����,���Ķ���"+this+",sessionId:"+event.getSession().getId());

	}

}
