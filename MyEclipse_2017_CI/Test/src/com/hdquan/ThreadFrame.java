package com.hdquan;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThreadFrame extends JFrame implements ActionListener{

	JTextField showWord;
	JTextField inputText,showScore;
	JButton button;
	WordThread giveWord;
	int score=0;
	ThreadFrame()
	{
		showWord=new JTextField(6);
		showWord.setFont(new Font("",Font.BOLD,72));
		showWord.setHorizontalAlignment(JTextField.CENTER);
		
		giveWord=new WordThread();
		giveWord.setJTextField(showWord);
		giveWord.setSleepLength(5000);
		
		button=new JButton("开始");
		inputText=new JTextField(10);
		showScore=new JTextField(5);
		showScore.setEditable(false);
		
		button.addActionListener(this);
		inputText.addActionListener(this);
		
		JPanel southP=new JPanel();
		southP.add(new JLabel("输入汉字（回车）："));
		southP.add(showScore);
		southP.add(inputText);
		
		add(button,BorderLayout.NORTH);
		add(showWord,BorderLayout.CENTER);
		add(southP,BorderLayout.SOUTH);
		
		setBounds(100, 100, 350, 180);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			if(!(giveWord.isAlive()))
			{
				WordThread giveWord=new WordThread();
				giveWord.setJTextField(showWord);
				giveWord.setSleepLength(5000);
			}
			try {
				giveWord.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==inputText)
		{
			if(inputText.getText().equals(showWord.getText()))
			{
				score++;
			}
			showScore.setText("得分："+score);
			inputText.setText(null);
		}
	}

}
