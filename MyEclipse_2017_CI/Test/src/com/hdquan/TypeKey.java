package com.hdquan;

public class TypeKey {
	  public static void main(String args[]) {
	      System.out.println("������ϰ(����#��������)");
	      System.out.printf("������ʾ����ĸ(�س�)\n");
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
