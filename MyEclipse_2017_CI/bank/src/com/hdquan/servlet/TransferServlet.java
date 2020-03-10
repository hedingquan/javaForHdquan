package com.hdquan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hdquan.pojo.Account;
import com.hdquan.service.AccountService;
import com.hdquan.service.impl.AccountServiceImpl;
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{
		private	AccountService accService=new AccountServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Account accOut=new Account();
			accOut.setAccNO(req.getParameter("accOutAccNo"));
			accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
			accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
			Account accIn=new Account();
			accIn.setAccNO(req.getParameter("accInAccNo"));
			accIn.setName(req.getParameter("accInAccName"));
			int index=accService.transfer(accIn, accOut);
			if(index==AccountService.SUCCESS)
			{
				res.sendRedirect("/bank/show");//跳转页面
			}
			else
			{
				HttpSession session=req.getSession();
				session.setAttribute("code", index);
				res.sendRedirect("/bank/error/error.jsp");
			}
	}
}