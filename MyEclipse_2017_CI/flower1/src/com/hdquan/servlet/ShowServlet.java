package com.hdquan.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.pojo.flower;
import com.hdquan.service.FlowerService;
import com.hdquan.service.impl.flowerserviceImpl;
@WebServlet("/show")//<url-pattern>/show</url-pattern>,鍗充负/show銆傘�傘��/锛氫唬琛ㄦ嫤鎴鍒欙紝/show锛氭嫤鎴牴鐩綍涓嬩互鈥渟how"鏂瑰紡璇锋眰鐨勫唴瀹广��
public class ShowServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService=new flowerserviceImpl();//鍏ㄥ眬鍙橀噺锛岀敱浜巉lowerService缁忓父鐢ㄣ��
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	List<flower> list=flowerService.show();//杩斿洖鐨勬槸涓�涓泦鍚堛��
	req.setAttribute("list", list);//瓒婂皬瓒婂ソ銆傜涓�涓负璧风殑鍚嶅瓧锛�
	req.getRequestDispatcher("index.jsp").forward(req, res);//璇锋眰杞彂.浣跨敤req鏃惰鐢ㄨ繖涓�傝浆鍙戝埌index.jsp
	}
}
