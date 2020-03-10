package com.hdquan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MobileServlet
 */
@WebServlet("/MobileServlet")
public class MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String mobile=request.getParameter("mobile");
		PrintWriter out = response.getWriter();
	
		if("1".equals(mobile))
		{
//			out.write("true");//servlet��������ķ�ʽ������Ϣ���ظ��ͻ���
//			out.write("�˺����Ѵ���");
			//����ͻ�����getjon����������Ҫ��json��ʽ��������
			out.write("{\"msg\":\"true\"}");//	"	{\"msg\":\"true\"}	"
//			out.print("{\"msg\":\"true\"}");��writeûʲô������Ҫ���ڿ��Դ���ȥ�Ĳ����Ĳ�ͬ��pritln�Ĳ�����һ��
		}else
		{
//			out.write("false");
//			out.write("ע��ɹ�");
			out.write("{\"msg\":\"false\"}");		//	"	{\"msg\":\"false\"}	"
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
