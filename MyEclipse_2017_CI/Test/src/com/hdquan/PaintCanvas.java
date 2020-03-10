package com.hdquan;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class PaintCanvas extends Canvas{
	BufferedImage image;
	Graphics2D g_2d;
	PaintCanvas()
	{
		image=new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
		g_2d=image.createGraphics();
		Rectangle2D rect=new Rectangle2D.Double(0,0,300,300);
		Ellipse2D ellipse=new Ellipse2D.Double(30,30,80,30);
		g_2d.setColor(Color.yellow);
		g_2d.fill(rect);
		g_2d.setColor(Color.black);
		AffineTransform trans=new AffineTransform();
		for(int i=0;i<=24;i++)
		{
			trans.rotate(15.0*Math.PI/180,7,45);
			g_2d.setTransform(trans);
			g_2d.draw(ellipse);	
		}
		}
	public BufferedImage getImage()
	{
		return image;
	}
}