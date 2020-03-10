package com.hdquan.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.Util.WriteJson;
import com.hdquan.pojo.Account;
import com.hdquan.service.WaterElectricService;

@Controller
public class PrintController {
	@Autowired
	private WaterElectricService waterElectricService;
	
	@RequestMapping("print.action")
	public void print(HttpServletRequest request,HttpServletResponse response,
			String year,String season, String name1, String id1, String salaryNum, String building,
			String unit) throws IOException, ServletException
		{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    if(year!=null||season!=null||name1!=null||id1!=null||salaryNum!=null||building!=null||unit!=null)
		    {
				    List<Account> limitSearchAccount = waterElectricService.limitSearchAccount(year, season, name1, id1, salaryNum, building, unit);
				   request.setAttribute("print", limitSearchAccount);
				    request.getRequestDispatcher("print.jsp").forward(request, response);
		    }else{
			    List<Account> teacherAccount = waterElectricService.TeacherAccount();
			    request.setAttribute("print", teacherAccount);
			    request.getRequestDispatcher("print.jsp").forward(request, response);
			}
		}
	
	@RequestMapping("OtherPrint.action")
	public void OtherPrint(HttpServletRequest request,HttpServletResponse response,String year,String month, String name1, String buildingName, String roomNum) throws IOException, ServletException
		{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    if(year!=null||month!=null||name1!=null||buildingName!=null||roomNum!=null)
		    {
				    List<Account> otherlimitSearchAccount = waterElectricService.OtherlimitSearchAccount(year, month, name1, buildingName, roomNum);
				   request.setAttribute("print", otherlimitSearchAccount);
				    request.getRequestDispatcher("OtherPrint.jsp").forward(request, response);
		    }else{
			      List<Account> otherAccount = waterElectricService.OtherAccount();
			    request.setAttribute("print", otherAccount);
			    request.getRequestDispatcher("OtherPrint.jsp").forward(request, response);
			}
		}
	
	@RequestMapping("statistics.action")
	public void statistics(HttpServletRequest request,HttpServletResponse response,
			String year,String season, String name1, String id1, String salaryNum, String building,
			String unit) throws IOException, ServletException
		{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    if(year!=null||season!=null||name1!=null||id1!=null||salaryNum!=null||building!=null||unit!=null)
		    {
				    List<Account> limitSearchAccount = waterElectricService.limitSearchAccount(year, season, name1, id1, salaryNum, building, unit);
				   request.setAttribute("statistics", limitSearchAccount);
				    request.getRequestDispatcher("statistics.jsp").forward(request, response);
		    }else{
			    List<Account> teacherAccount = waterElectricService.TeacherAccount();
			    request.setAttribute("statistics", teacherAccount);
			    request.getRequestDispatcher("statistics.jsp").forward(request, response);
			}
		}
}
