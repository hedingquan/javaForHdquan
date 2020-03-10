package com.hdquan.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdquan.Util.WriteJson;
import com.hdquan.pojo.Account;
import com.hdquan.pojo.Building;
import com.hdquan.pojo.Room;
import com.hdquan.pojo.Unit;
import com.hdquan.service.BuildingService;

@Controller
public class BuildingController {

	@Autowired
	private BuildingService buildingServiceService;
	
	@RequestMapping("allBuilding.action")
	public void allBuilding(HttpServletRequest request,HttpServletResponse response,String buildingName) throws IOException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    if(buildingName==null)
		    {
		    	 List<Building> allBuilding = buildingServiceService.allBuilding();
				    Map<String,Object> m=new HashMap<String,Object>();
					m.put("total",allBuilding.size());
					m.put("rows",allBuilding);
					WriteJson.writeJson(m,response);
		    }else{
		    	 List<Building> limitBuilding = buildingServiceService.limitBuilding(buildingName);
				    Map<String,Object> m=new HashMap<String,Object>();
					m.put("total",limitBuilding.size());
					m.put("rows",limitBuilding);
					WriteJson.writeJson(m,response);
		    }
	}
	
	@RequestMapping("BuildingNameForWaterElectri.action")
	public void BuildingNameForWaterElectri(HttpServletRequest request,HttpServletResponse response,String buildingName) throws IOException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    if(buildingName==null)
		    {
		    	 List<Building> buildingName2 = buildingServiceService.BuildingName();
					WriteJson.writeJson(buildingName2,response);
		    }else{
		    	 List<Building> limitBuilding = buildingServiceService.OtherBuildingName();
		    	 WriteJson.writeJson(limitBuilding,response);
		    }
	}
	
	@RequestMapping("UnitForWaterElectri.action")
	public void UnitForWaterElectri(HttpServletRequest request,HttpServletResponse response,String buildingName) throws IOException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		 List<Unit> unitName = buildingServiceService.unitName();
		 WriteJson.writeJson(unitName,response);
	}
	
	@RequestMapping("roomNumForWaterElectri.action")
	public void roomNumForWaterElectri(HttpServletRequest request,HttpServletResponse response,String buildingName) throws IOException
	{
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		 List<Room> rooms = buildingServiceService.Rooms(buildingName);
		 WriteJson.writeJson(rooms,response);
	}
	
	@RequestMapping("AddBuildingInfo.action")
	public void AddBuildingInfo(HttpServletRequest request,HttpServletResponse response,String bId,String buildingName,String category) throws IOException, IllegalAccessException, InvocationTargetException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		    response.setHeader("Content-Type" , "text/html");
		    
		    Building building=new Building();
		    if(!"".equals(bId.trim()))
		    {
		    	BeanUtils.populate(building, request.getParameterMap());
		    	buildingServiceService.updateBuilding(building);
		    }else{
					BeanUtils.populate(building, request.getParameterMap());
					buildingServiceService.addBuilding(building);
		    	}
		    	}
	@RequestMapping("deleteBuilding.action")
	public void deleteBuilding(HttpServletRequest request,HttpServletResponse response,String id) throws IOException, IllegalAccessException, InvocationTargetException
	{	
		 request.setCharacterEncoding( "utf-8" );
		 response.setCharacterEncoding("utf-8");
		  response.setHeader("Content-Type" , "text/html");
		  buildingServiceService.deleteBuilding(buildingServiceService.getBuilding(Integer.parseInt(id)));
	}
 }
