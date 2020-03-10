package com.hdquan.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoSocket {
		
	public EchoSocket()
	{
		System.out.println("EchoSocket.EchoSocket()");
		
	}
	
	
	@OnOpen
	public void open(Session session)
	{
		//一个session代表一个通信会话!!!
		System.out.println(session.getId());
		
	}
	@OnClose
	public void close(Session session){
		System.out.println(session.getId()+"关闭");	
	}
	
	@OnMessage
	public void message(Session session,String msg,boolean last)
	{
		//服务器端接受数据
		System.out.println("客户端："+msg);	
		try {
			//服务器端发送数据
			session.getBasicRemote().sendText("服务器：嘿嘿");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
