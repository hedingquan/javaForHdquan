package com.hdquan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdquan.entity.Student;

/**
 * Servlet implementation class ELInitServlet
 */
@WebServlet("/ELInitServlet")
public class ELInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student=new Student();
		student.setAge(23);
		student.setName("zs");
		
		Student student1=new Student();
		student1.setAge(44);
		student1.setName("ls");
		
		List<Student> studnets=new ArrayList<>();
		studnets.add(student1);
		studnets.add(student);
		request.setAttribute("studnets", studnets);
		
		//将student放入request域中
		request.setAttribute("student", student);
		request.setAttribute("my-name", "权");
		
		String[] hobbies=new String[]{"football","pingpang","basketball"};
		request.setAttribute("hobbies", hobbies);
		
		Map<String,Object> map=new HashMap<>();
		map.put("cn", "中国");
		map.put("us", "美国");
		request.setAttribute("countries", map);
		
		request.setAttribute("nullValue", null);
		
		request.getSession().setAttribute("sessionKey", "sessionValue");
		
		
		String[] names=new String[]{"aaa","bb","cc"};
		request.setAttribute("names", names);
		
		
		
		request.getRequestDispatcher("jstl2.jsp").forward(request, response);;//实现跳转
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
