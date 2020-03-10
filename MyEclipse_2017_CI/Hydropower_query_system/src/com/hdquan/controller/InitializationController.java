package com.hdquan.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.Util.WriteJson;
import com.hdquan.pojo.Account;
import com.hdquan.service.WaterElectricService;

@Controller
public class InitializationController {
	@Autowired
	private WaterElectricService waterElectricService;
	
	@RequestMapping("TeacherElectricInitialization.action")
	public void TeacherElectricInitialization(HttpServletRequest request,HttpServletResponse response,
			String year1,String season1,String electricBill,String waterBill,String check_electric_time,String check_water_time
			) throws IOException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    List<Account> teacherAccount = waterElectricService.TeacherAccount();
		    for(Account account:teacherAccount)
		    {
		    	Account account2=new Account();
		    	BeanUtils.copyProperties(account, account2);
		    	account2.setLastelectricNum(account2.getElectricNum());
		    	account2.setLastewaterNum(account2.getWaterNum());
		    	account2.setElectricNum(null);
		    	account2.setWaterNum(null);
		    	account2.setSeason(year1+season1);
		    	account2.setElectricBill(electricBill);
		    	account2.setWaterBill(waterBill);
		    	account2.setCheck_electric_time(check_electric_time);
		    	account2.setCheck_water_time(check_water_time);
		    	waterElectricService.addAccount(account2);
		    }
	}
	@RequestMapping("OtherElectricInitialization.action")
	public void OtherElectricInitialization(HttpServletRequest request,HttpServletResponse response,
			String year4,String season4
			) throws IOException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    List<Account> otherAccount = waterElectricService.OtherAccount();
		    for(Account account:otherAccount)
		    {
		    	Account account2=new Account();
		    	BeanUtils.copyProperties(account, account2);
		    	account2.setLastelectricNum(account2.getElectricNum());
		    	account2.setLastewaterNum(account2.getWaterNum());
		    	account2.setElectricNum(null);
		    	account2.setWaterNum(null);
		    	account2.setSeason(year4+season4);
		    	waterElectricService.addAccount(account2);
		    }
	}
}
