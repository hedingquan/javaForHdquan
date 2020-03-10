package com.hdquan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.entity.Student;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
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
		PrintWriter out = response.getWriter();
		
		//测试前端传来的数据
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		System.out.println(name+"---"+age);
		
		Student stu1=new Student();
		stu1.setAge(23);
		stu1.setName("zs");
		
		Student stu2=new Student();
		stu2.setAge(24);
		stu2.setName("ls");
		
		Student stu3=new Student();
		stu3.setAge(25);
		stu3.setName("ww");
		
		JSONObject json=new JSONObject();
		json.put("stu1",stu1);
		json.put("stu2",stu2);
		json.put("stu3",stu3);//"stu1":stu1, "stu2":stu2,"stu3":stu3
//		out.write(json);//返回json对象		key="stu1"  value=stu1对象
		out.print(json);
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
