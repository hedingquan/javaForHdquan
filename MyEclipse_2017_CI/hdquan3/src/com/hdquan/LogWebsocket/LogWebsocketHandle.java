package com.hdquan.LogWebsocket;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.WriterAppender;
import org.springframework.stereotype.Component;

import com.hdquan.NewThread.LogThread;

@ServerEndpoint("/log")
@Component
public class LogWebsocketHandle {

  private PipedReader reader;
  private Writer writer;

  private static CopyOnWriteArraySet<LogWebsocketHandle> sessions = new CopyOnWriteArraySet<LogWebsocketHandle>();
  private  Session session;

  /**
   * WebSocket请求开启
   */
  @OnOpen
  public void onOpen(Session session) {
	  this.session = session;
      sessions.add(this);
    Logger root = Logger.getRootLogger();
    try {
      String hostAddress = InetAddress.getLocalHost().getHostAddress();
      MDC.put("hdquan","欢迎来到权限管理系统");
      Appender appender = root.getAppender("WA");
      reader = new PipedReader();
      writer = new PipedWriter(reader) ;
      ((WriterAppender) appender).setWriter(writer);
      LogThread thread = new LogThread(reader, session);
      thread.start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * WebSocket请求关闭，关闭请求时调用此方法，关闭流
   */
  @OnClose
  public void onClose() {
    try {
      if(reader != null) {
        reader.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    try {
      if(writer != null) {
        writer.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("设置离线");
    sessions.remove(this);
  }

  @OnError
  public void onError(Throwable thr) {
    thr.printStackTrace();
  }
}
