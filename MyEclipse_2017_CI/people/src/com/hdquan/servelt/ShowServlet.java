package com.hdquan.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.pojo.people;
import com.hdquan.sericeImpl.PeopleServiceImpl;
import com.hdquan.service.PeopleService;

@WebServlet(value={"/abc/b/show"})
public class ShowServlet extends HttpServlet{
	private PeopleService peopleService=new PeopleServiceImpl(); 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<people> list=peopleService.show();
		req.setAttribute("list",list);//传过去
		req.getRequestDispatcher("../../index.jsp").forward(req, res);//请求转发，表示WebRoot的目录
		
		
		
	}
}
