package com.hdquan;

import javax.swing.JFrame;

public class Fan {
	 public static void main(String args[]) {
	      JFrame win = new JFrame();
	      win.setSize(400,400);
	      win.add(new MyCanvas());
	      win.setVisible(true);  
	      win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	   }     

}
