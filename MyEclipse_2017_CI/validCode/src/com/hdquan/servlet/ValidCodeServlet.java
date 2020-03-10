package com.hdquan.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//创建一张图片
		//单位：像素
		BufferedImage image=new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
		//透明的玻璃
		Graphics2D gra = image.createGraphics();
		gra.setColor(Color.WHITE);
		gra.fillRect(0, 0, 200, 100);//填充一个矩形区域
		
		List<Integer> randlist=new ArrayList<Integer>();
		Random random =new Random();
		for(int i=0;i<4;i++)
		{
			randlist.add(random.nextInt(10));
		}
		//设置字体
		gra.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,40));
		Color[] colors=new Color[]{Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.PINK,Color.GRAY};
		for(int i=0;i<randlist.size();i++)
		{
			gra.setColor(colors[random.nextInt(colors.length)]);//随机颜色
		gra.drawString(randlist.get(i)+"", i*40, 70+(random.nextInt(21)-20));
		}
		for(int i=0;i<2;i++)
		{
			gra.setColor(colors[random.nextInt(colors.length)]);
			//画横线
			gra.drawLine(0,random.nextInt(101), 200, random.nextInt(101));			
		}
		
		
		ServletOutputStream outputStream = res.getOutputStream();
		//工具类
		ImageIO.write(image, "jpg", outputStream);
		
		HttpSession session = req.getSession();
		session.setAttribute("code", ""+randlist.get(0)+randlist.get(1)+randlist.get(2)+randlist.get(3));
	}
} 
