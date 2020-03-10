package com.hdquan;

import java.io.*;
import java.net.*;
import java.util.*;
public class ServerNumber {
   public static void main(String args[]) {
      ServerSocket server=null;
      ServerThread16 thread;
      Socket you=null;
      while(true) { 
          try{  server= new ServerSocket(4332);
              }
          catch(IOException e1) 
             {  System.out.println("���ڼ���");   
             } 
          try{  you= server.accept();
                System.out.println("�ͻ��ĵ�ַ:"+you.getInetAddress());
             }
         catch (IOException e)
             {  System.out.println("���ڵȴ��ͻ�");
             }
         if(you!=null) 
             {  new ServerThread16(you).start();  
             }
         else 
             {  continue;
             }
      }
   }
}
class ServerThread16 extends Thread {
   Socket socket;
   DataInputStream in=null; 
   DataOutputStream out=null;
   ServerThread16(Socket t) {
      socket=t;
      try  { out=new DataOutputStream(socket.getOutputStream()); 
             in=new DataInputStream(socket.getInputStream());
           }
      catch (IOException e) {}
   }  
   public void run() { 
      try{
           while(true) {
              String str = in.readUTF(); 
              boolean boo =str.startsWith("Y")||str.startsWith("y"); 
              if(boo) {
                 out.writeUTF("����һ��1��100֮��������,������Ƕ���ѽ!");
                 Random random=new Random();  
                 int realNumber = random.nextInt(100)+1;
                 handleClientGuess(realNumber);
                 out.writeUTF("ѯ��:�����������Y����������N:");
              }
              else {
                 return;
              }
           } 
      }
      catch(Exception exp){}
   } 
   public void handleClientGuess(int realNumber){
       while(true) {
          try{  int clientGuess = in.readInt(); 
                System.out.println(clientGuess);
                if(clientGuess>realNumber)
                    out.writeUTF("�´���");
                else if(clientGuess<realNumber)
                    out.writeUTF("��С��");
                else if(clientGuess==realNumber) {
                    out.writeUTF("�¶��ˣ�");
                    break;
                }
          }
          catch (IOException e) {
                System.out.println("�ͻ��뿪");
                return;
          }
      }
   }
}
