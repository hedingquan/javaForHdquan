package com.hdquan.servlet;

import java.io.IOException;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService=new flowerserviceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//闃叉鎻愪氦鐨勬椂鍊欎腑鏂囦贡鐮�
	//	res.setCharacterEncoding(arg0);//瑙ｅ喅鍝嶅簲涓殑涔辩爜
	//	res.setContentType(arg0);
		String name=req.getParameter("name");//name鏄捣鐨勫悕瀛�
		String price=req.getParameter("price");
		String production=req.getParameter("production");
		flower flower=new flower();
		flower.setName(name);
		flower.setPrice((Double.parseDouble(price)));//杩欓噷鐨刾rice鏄疭tring绫诲瀷鐨勶紝鎵�鏈夐渶瑕佽浆鍨嬨��
		flower.setProduction(production);
		int index=flowerService.add(flower);
		if(index>0)
		{//闃叉琛ㄥ崟閲嶅鎻愪氦
			res.sendRedirect("show");//鎴愬姛鐨勮瘽寰�show鍝噷璺�
//			req.getRequestDispatcher("show").forward(req, res);//杞彂(璺宠浆涓�娆�)鐨勬晥鐜囨瘮閲嶇疆椤�(璺宠浆涓ゆ锛夎楂�//杩欎釜鏄姹傝浆鍙戯紝涓轰竴娆°�備絾杩欎釜浼氶噸澶嶆彁浜よ姹傘�備竴鑸笉浣跨敤杩欎釜
		}
		else{
			res.sendRedirect("add.jsp");//鎴愬姛鐨勮瘽寰�add.jsp鍝噷璺�
//			req.getRequestDispatcher("add.jsp").forward(req, res);
		}
		
	}
}
