package com.hdquan;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeWin extends JFrame implements ActionListener{
	JButton bStart,bStop,imageButton;
	Timer time;
	int n=0,start=1,count;
	ImageIcon imageIcon[];
	TimeWin()
	{
		time=new Timer(500,this);
		imageIcon=new ImageIcon[10];
		count=imageIcon.length;
	for(int i=0;i<count;i++)
	{
		imageIcon[i]=new ImageIcon("tree"+i+".jpg");
		imageButton=new JButton(imageIcon[0]);
		bStart=new JButton("开始播放");
		bStop=new JButton("暂停播放");
		bStart.addActionListener(this);
		bStop.addActionListener(this);
		JPanel con=new JPanel();
		con.add(bStart);
		con.add(bStop);
		add(con,BorderLayout.SOUTH);
		add(con,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		validate();
		setVisible(true);
	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==time)
		{
			n=(n+1)%count;
			imageButton.setIcon(imageIcon[n]);
			
		}
		else if(e.getSource()==bStart)
		{
			time.start();
		}
		else if(e.getSource()==bStop)
		{
			time.stop();
		}
	}

	
}