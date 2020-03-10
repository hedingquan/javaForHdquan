package com.hdquan;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client15 {
	   public static void main(String args[]) {
		      Scanner scanner = new Scanner(System.in);
		      Socket mysocket=null;
		      ObjectInputStream inObject=null;
		      ObjectOutputStream outObject=null;
		      Thread thread ; 
		      ReadWindow15 readWindow=null;
		      try{  mysocket=new Socket();
		            readWindow = new ReadWindow15();   
		            thread = new Thread(readWindow);
		            System.out.print("�����������IP:");
		            String IP = scanner.nextLine();
		            System.out.print("����˿ں�:");
		            int port = scanner.nextInt();
		            if(mysocket.isConnected()){}
		            else{
		              InetAddress  address=InetAddress.getByName(IP);
		              InetSocketAddress socketAddress=new InetSocketAddress(address,port);
		              mysocket.connect(socketAddress); 
		              InputStream in = mysocket.getInputStream();
		              OutputStream out = mysocket.getOutputStream();
		              inObject =new ObjectInputStream(in); 
		              outObject = new ObjectOutputStream(out);
		              readWindow.setObjectInputStream(inObject);
		              thread.start();
		            }
		       }
		       catch(Exception e) {
		            System.out.println("�������ѶϿ�"+e);
		       }
		   }
		}
		class ReadWindow15 implements Runnable {
		   ObjectInputStream  in;
		   public void setObjectInputStream(ObjectInputStream  in) {
		      this.in = in;
		   }
		   public void run() {
		      double result = 0;
		      while(true) {
		        try{ javax.swing.JFrame window = (javax.swing.JFrame)in.readObject();
		             window.setTitle("���Ǵӷ������϶���Ĵ���");
		             window.setVisible(true);
		             window.requestFocusInWindow();
		             window.setSize(600,800); 
		            
		        }
		        catch(Exception e) { 
		             System.out.println("��������ѶϿ�"+e);
		             break;
		        }   
		      }
		   }
		}