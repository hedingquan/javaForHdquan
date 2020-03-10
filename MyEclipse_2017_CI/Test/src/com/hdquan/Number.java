package com.hdquan;

public class Number implements Runnable {
	   final int SMALLER=-1,LARGER=1,SUCCESS=8;
	   int realNumber,guessNumber,min=0,max=100,message=SMALLER;
	   boolean pleaseGuess=false,isGiveNumber=false;
	   Thread giveNumberThread,guessNumberThread;
	   Number() {
		   giveNumberThread=new Thread(this);
		   guessNumberThread=new Thread(this);
	   }
	   public void run() {
	      for(int count=1;true;count++) {
	         setMessage(count);
	         if( message==SUCCESS)
	            return;
	      }
	   }
	   public synchronized void setMessage(int count) {
	      if(Thread.currentThread()==giveNumberThread&&isGiveNumber==false) {
	          realNumber=(int)(Math.random()*100)+1;
	          System.out.println("随机给你一个1至100之间的数，猜猜是多少？");
	          isGiveNumber=true;
	          pleaseGuess=true;
	      }
	      if(Thread.currentThread()==giveNumberThread) {
	          while(pleaseGuess==true)             
	             try  { wait();  
	             }
	             catch(InterruptedException e){}
	             if(realNumber>guessNumber)  {
	                message=SMALLER;
	                System.out.println("你猜小了");
	             }
	             else if(realNumber<guessNumber) {
	                message=LARGER;
	                System.out.println("你猜大了");
	             } 
	             else {
	                message=SUCCESS;
	                System.out.println("恭喜，你猜对了");
	             }  
	             pleaseGuess=true;
	          }
	      if(Thread.currentThread()==guessNumberThread&&isGiveNumber==true) {
	             while(pleaseGuess==false)
	                try { wait();
	                }
	                catch(InterruptedException e){}
	                if(message==SMALLER) {
	                   min=guessNumber;
	                   guessNumber=(min+max)/2; 
	                   System.out.println("我第"+count+"次猜这个数是:"+guessNumber);
	                }
	                else if(message==LARGER) {
	                   max=guessNumber;
	                   guessNumber=(min+max)/2; 
	                   System.out.println("我第"+count+"次猜这个数是:"+guessNumber);
	                }
	                pleaseGuess=false; 
	      }
	      notifyAll();
	   }
	}
