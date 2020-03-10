package com.chat;

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

import com.pojo.Content;
import com.pojo.Message;

import net.sf.json.JSONObject;

@ServerEndpoint("/chatSocket")
public class chatSocket {
	
	private String username;
	private static List<Session> sessions=new ArrayList<Session>();
	private static List<String> names=new ArrayList<String>();
	private static Map<String,Session> map=new HashMap<String, Session>();
	
	
	@OnOpen
	public void open(Session session)
	{
		String queryString = session.getQueryString();
		Map<String, String> pathParameters = session.getPathParameters();
		username = queryString.split("=")[1];
		this.names.add(username);
		this.sessions.add(session);
		this.map.put(this.username,session);
		
		Message message=new Message();
		message.setUsernames(this.names);
		String msg="欢迎"+this.username+"进入聊天室！！<br/>";
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
		String msg="欢送"+this.username+"离开聊天室！！<br/>";
		message.setWelcome(msg);
		broadcast(this.sessions, message.toJson());
	}
	
	@OnMessage
	public void message(Session session,String json)
	{
		Content content = (Content) JSONObject.toBean(JSONObject.fromObject(json), Content.class);
		if(content.getType()==1)
		{
			Message message=new Message();
			message.setContent(this.username,username+"说："+content.getMsg());		
			broadcast(this.sessions, message.toJson());
		}else{
			String to = content.getTo();
			Session toSession2 = this.map.get(to);
			Message message=new Message();
			message.setContent(this.username,"<font color=red>"+username+"对您私聊："+content.getMsg()+"</font>");		
			try {
				toSession2.getBasicRemote().sendText(message.toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
