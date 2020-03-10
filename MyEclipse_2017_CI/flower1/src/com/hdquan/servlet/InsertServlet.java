package com.hdquan.servlet;
import com.hdquan.dao.FlowerDao;
import com.hdquan.dao.impl.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.pojo.flower;
import com.hdquan.service.FlowerService;
import com.hdquan.service.impl.flowerserviceImpl;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService=new flowerserviceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	//	res.setCharacterEncoding(arg0);
	//	res.setContentType(arg0);
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String production=req.getParameter("production");
		flower flower=new flower();
		flower.setName(name);
		flower.setPrice((Double.parseDouble(price)));
		flower.setProduction(production);
		System.out.println(flower.getname());
		int index=flowerService.add(flower);
		System.out.println(flower.getname());
		System.out.println("加藤");
		if(index>0)
		{
			res.sendRedirect("show");
//			req.getRequestDispatcher("show").forward(req, res);
		}
		else{
		res.sendRedirect("add.jsp");
//			req.getRequestDispatcher("add.jsp").forward(req, res);
		}
		//List<flower> list=new ArrayList<>();
//		
//		fd.selAll();
//		FlowerDao.insFlower(flower);
//		
		
		
	}
}
