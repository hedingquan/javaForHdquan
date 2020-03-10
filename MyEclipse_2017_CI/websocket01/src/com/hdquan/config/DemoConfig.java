package com.hdquan.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class DemoConfig implements ServerApplicationConfig{

	//注解方式的启动
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scaned) {
		// TODO Auto-generated method stub
		//src下扫描到的类有几个？---scaned.size()
	System.out.println("config......"+scaned.size());
	//返回提供了过滤的作用！！
		return scaned;
	}
	//接口方式的启动
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
