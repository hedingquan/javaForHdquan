package com.hdqu.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

//����BeanListener2����Ķۻ��ͻ
public class BeanListener2 implements HttpSessionActivationListener{
	//׼�����ۻ����������
	private int num;
	private String user;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	//����ʱ�̣��ոս����˻֮��
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {

	}
	//����ʱ�̣������ۻ�֮ǰ
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
	System.out.println("�����ۻ�֮ǰ:BeanListener2���󽫻�����session�Ķۻ����ۻ�");
	}
	
}
