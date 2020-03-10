package com.hdquan;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Server15 {
	   public static void main(String args[]) {
		      ServerSocket server=null;
		      ServerThread15 thread;
		      Socket you=null;
		      while(true) { 
		          try{  server= new ServerSocket(4331);
		              }
		          catch(IOException e1) 
		             {  System.out.println("���ڼ���");   
		             } 
		          try{  you=  server.accept();
		                System.out.println("�ͻ��ĵ�ַ:"+you.getInetAddress());
		             }
		         catch (IOException e)
		             {  System.out.println("���ڵȴ��ͻ�");
		             }
		         if(you!=null) 
		             {  new ServerThread15(you).start();  
		             }
		         else 
		             {  continue;
		             }
		      }
		   }
		}
		class ServerThread15 extends Thread {
		   Socket socket;
		   ObjectInputStream in=null; 
		   ObjectOutputStream out=null;
		   JFrame window;
		   JTextArea text;
		   ServerThread15(Socket t) {
		      socket=t;
		      try  { out=new ObjectOutputStream(socket.getOutputStream()); 
		             in=new ObjectInputStream(socket.getInputStream());
		           }
		      catch (IOException e) {}
		      window =new JFrame();
		      text = new JTextArea();
		      for(int i=1;i<=20;i++) {  
		         text.append("���,���Ƿ������ϵ��ı������\n");
		      }
		      text.setBackground(Color.yellow);
		      window.add(text);
		      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		   }  
		   public void run() {        
		      try{  out.writeObject(window);
		      }
		      catch (IOException e) {
		         System.out.println("�ͻ��뿪");
		      }
		   } 
		}