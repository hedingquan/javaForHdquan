package com.hdquan.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.hdquan.pojo.Content;
import com.hdquan.pojo.Message;

@ServerEndpoint("/chatSocket")
public class chatSocket {
	
	private String username;
	private static List<Session> sessions=new ArrayList<Session>();
	private static List<String> names=new ArrayList<String>();
	private static Map<String,Session> map=new HashMap<String, Session>();
	
	
	@OnOpen
	public void open(Session session)
	{
		//当前websocket的session对象，不是servlet的session！！，不能取到登录用户的session信息
		String queryString = session.getQueryString();//把？后面的参数都获取到
		Map<String, String> pathParameters = session.getPathParameters();//根据？后面的分割开来
		System.out.println(queryString);
		System.out.println(pathParameters);

		username = queryString.split("=")[1];
		
		this.names.add(username);
		this.sessions.add(session);
		this.map.put(this.username,session);
		
		Message message=new Message();
		message.setUsernames(this.names);
		String msg="欢迎"+this.username+"进入聊天室！！";
		message.setWelcome(msg);
		this.broadcast(this.sessions,message.toJson());//this表示当前对象
	}
	
	public void broadcast(List<Session> ss,String msg)
	{
		for(Iterator iterator=ss.iterator();iterator.hasNext();)
		{
			Session session=(Session)iterator.next();
			try {
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@OnClose
	public void close(Session session)
	{
		this.sessions.remove(session);
		this.names.remove(this.username);
		Message message=new Message();
		message.setUsernames(this.names);
		String msg="欢送"+this.username+"离开聊天室！！";
		message.setWelcome(msg);
		broadcast(this.sessions, message.toJson());
	}
	
	@OnMessage
	public void message(Session session,String json)
	{
		//json转换为对象
		Content content=new Content();
		if(content.getType()==1)
		{
			//广播
			Message message=new Message();
			message.setContent(this.username,content.getMsg());		
			broadcast(this.sessions, message.toJson());
		}else{
			//单聊
			String to = content.getTo();
			Session toSession2 = this.map.get(to);//根据key找到session
			Message message=new Message();
			message.setContent(this.username,"<font color=red>私聊："+content.getMsg()+"</font>");		
			try {
				toSession2.getBasicRemote().sendText(message.toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
