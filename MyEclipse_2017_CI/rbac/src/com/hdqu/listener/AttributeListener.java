package com.hdqu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletRequestAttributeListener,HttpSessionAttributeListener,ServletContextAttributeListener{
	//application.setAttribute("name","zs");
	//增加属性
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		String attrName=scae.getName();//目前正在操作的属性名，相当于key
		Object attribute = scae.getServletContext().getAttribute(attrName);//相当于value
		
		System.out.println("ServletContext【增加】属性：属性名"+attrName+",属性值:"+attribute);
	}
	//删除属性
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeRemoved(scae);
	}
	//第一次叫新增属性
	//第二次叫替换属性
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
