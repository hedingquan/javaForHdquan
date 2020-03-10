package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Building;
import com.hdquan.pojo.Room;
import com.hdquan.pojo.Unit;

public interface BuildingService {
	
	public List<Building> allBuilding();
	
	public List<Building> limitBuilding(String buildingName);
	
	public Building getBuilding(int id);
	
	public Building updateBuilding(Building building);
	
	public Building addBuilding(Building building);
	
	public Building deleteBuilding(Building building);
	
	public List<Building> BuildingName();
	
	public List<Building> OtherBuildingName();
	
	public List<Unit> unitName();
	
	public List<Room> Rooms(String buildingName);
	
	public Building getBuilding(String buildingName);
	
	public Room getRoom(String roomNum);
	
	public Unit getUnit(String uName);
}
