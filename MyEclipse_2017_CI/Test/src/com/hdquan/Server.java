package com.hdquan;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Server {
   public static void main(String args[]) {
      ServerSocket server=null;
      ServerThread thread;
      Socket you=null;
      while(true) { 
          try{  server=new ServerSocket(4331);
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
             {  new ServerThread(you).start();  
             }
         else 
             {  continue;
             }
      }
   }
}
class ServerThread extends Thread {
	   Socket socket;
	   ObjectInputStream in=null; 
	   ObjectOutputStream out=null;
	   JFrame window;
	   JTextArea text;
	   ServerThread(Socket t) {
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
