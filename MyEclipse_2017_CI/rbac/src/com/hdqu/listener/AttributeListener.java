package com.hdqu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletRequestAttributeListener,HttpSessionAttributeListener,ServletContextAttributeListener{
	//application.setAttribute("name","zs");
	//��������
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		String attrName=scae.getName();//Ŀǰ���ڲ��������������൱��key
		Object attribute = scae.getServletContext().getAttribute(attrName);//�൱��value
		
		System.out.println("ServletContext�����ӡ����ԣ�������"+attrName+",����ֵ:"+attribute);
	}
	//ɾ������
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeRemoved(scae);
	}
	//��һ�ν���������
	//�ڶ��ν��滻����
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeReplaced(scae);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeAdded(se);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeRemoved(se);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeReplaced(se);
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeAdded(srae);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeRemoved(srae);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeReplaced(srae);
	}

}
