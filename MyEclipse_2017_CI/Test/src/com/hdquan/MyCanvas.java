package com.hdquan;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class MyCanvas extends JPanel implements ActionListener{
	javax.swing.Timer timer;
	Arc2D arc1,arc2,arc3,arc4,arc5;
	Line2D line;
	Ellipse2D ellipse;
	AffineTransform trans;
	BasicStroke bs;
	MyCanvas()
	{
		arc1=new Arc2D.Double(60,60,100,100,0,20,Arc2D.PIE);
		arc2=new Arc2D.Double(60,60,100,100,72,20,Arc2D.PIE);
		arc3=new Arc2D.Double(60,60,100,100,144,20,Arc2D.PIE);
		arc4=new Arc2D.Double(60,60,100,100,216,20,Arc2D.PIE);
		arc5=new Arc2D.Double(60,60,100,100,288,20,Arc2D.PIE);
		line=new Line2D.Double(110,110,110,190);
		ellipse=new Ellipse2D.Double(100,100,20,20);
		bs=new BasicStroke(8f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND);
		trans=new AffineTransform();
		 timer = new javax.swing.Timer(10,this);
		timer.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, this.getBounds().width,this.getBounds().height);
		  Graphics2D g_2d=(Graphics2D)g;
	      g_2d.setStroke(bs);
	      g_2d.setColor(Color.blue);  
	      g_2d.draw(line);
	      g_2d.setColor(Color.black);
	      g_2d.fill(ellipse); 
	      trans.rotate(2.0*Math.PI/180,110,110);
	      g_2d.setTransform(trans);
	      g_2d.fill(arc1); 
	      g_2d.fill(arc2);
	      g_2d.fill(arc3); 
	      g_2d.fill(arc4);
	      g_2d.fill(arc5);
	}
}