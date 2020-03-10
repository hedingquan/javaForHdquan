package com.hdquan;

public class Block {
	   String name;
	   int number;
	   boolean boo=false;
	   public void setName(String name) {
	      this.name=name; 
	   }
	   public void setNumber(int n) {
	      number=n;
	   }
	   public int getNumber() {
	      return number;
	   }
	   public String getName() {
	     return name;  
	   }
	   boolean isMine() {
	     return boo;
	   } 
	   public void setIsMine(boolean boo) {
	    this.boo=boo; 
	   }
	}
