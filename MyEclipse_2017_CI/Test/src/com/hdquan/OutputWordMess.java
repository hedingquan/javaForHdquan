package com.hdquan;


import java.util.Vector;
public class OutputWordMess{
   public static void main(String args[]) {
      Vector<String> allWord,noSameWord;
      WordStatistic statistic =new WordStatistic();
      statistic.setFileName("hello.txt"); 
      statistic.wordStatistic(); //statistic����wordStatistic()���� 
      allWord=statistic.getAllWord();
      noSameWord=statistic.getNoSameWord();
      System.out.println("����"+allWord.size()+"��Ӣ�ĵ���");
      System.out.println("��"+noSameWord.size()+"��������ͬӢ�ĵ���");
      System.out.println("������Ƶ������:");
      int count[]=new int[noSameWord.size()];
      for(int i=0;i<noSameWord.size();i++) {
           String s1 = noSameWord.elementAt(i);
             for(int j=0;j<allWord.size();j++) {
                String s2=allWord.elementAt(j);
                if(s1.equals(s2))
                    count[i]++;
             }       
      }
      for(int m=0;m<noSameWord.size();m++) {
          for(int n=m+1;n<noSameWord.size();n++) {
             if(count[n]>count[m]) {
                String temp=noSameWord.elementAt(m);
                 noSameWord.setElementAt(noSameWord.elementAt(n),m);
                 noSameWord.setElementAt(temp,n);
                 int t=count[m];
                 count[m]=count[n];
                 count[n]=t;
             }
          }
      }
      for(int m=0;m<noSameWord.size();m++) {
         double frequency=(1.0*count[m])/allWord.size();  
         System.out.printf("%s:%-7.3f",noSameWord.elementAt(m),frequency); 
      }
   }
}



