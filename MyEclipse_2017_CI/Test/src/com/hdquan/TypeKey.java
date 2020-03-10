package com.hdquan;

public class TypeKey {
	  public static void main(String args[]) {
	      System.out.println("键盘练习(输入#结束程序)");
	      System.out.printf("输入显示的字母(回车)\n");
	      Letter letter;
	      letter = new Letter();
	      GiveLetterThread giveChar;
	      InuptLetterThread typeChar;
	      giveChar=new GiveLetterThread();
	      giveChar.setLetter(letter);
	      giveChar.setSleepLength(3200);
	      typeChar=new InuptLetterThread();
	      typeChar.setLetter(letter);
	      giveChar.start();
	      typeChar.run();
	   }
	}
